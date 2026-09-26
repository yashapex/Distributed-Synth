package com.distributed_synth.workspace_service.consumer;

import com.distributed_synth.common_library.event.FileStoreRequestEvent;
import com.distributed_synth.common_library.event.FileStoreResponseEvent;
import com.distributed_synth.workspace_service.entity.ProcessedEvent;
import com.distributed_synth.workspace_service.repository.ProcessedEventRepository;
import com.distributed_synth.workspace_service.service.ProjectFileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileStorageConsumer {

    private final ProjectFileService projectFileService;
    private final ProcessedEventRepository processedEventRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "file-storage-request-event", groupId = "workspace-group")
    @Transactional
    public void consumeFileEvent(FileStoreRequestEvent requestEvent){

        //Idempotency
        if(processedEventRepository.existsById(requestEvent.sagaId())){
            log.info("Duplicate saga detected: {}, Resending previous ACK", requestEvent.sagaId());
            sendResponse(requestEvent, true, null);
            return;
        }
        try {
            log.info("saving file: {}", requestEvent.filePath());
            projectFileService.saveFile(requestEvent.projectId(), requestEvent.filePath(), requestEvent.content());
            processedEventRepository.save(new ProcessedEvent(
                    requestEvent.sagaId(), LocalDateTime.now()
            ));
            sendResponse(requestEvent, true, null);
        } catch (Exception e){
            log.error("error saving file: {}", e.getMessage());
            sendResponse(requestEvent, false, e.getMessage());
        }
    }

    private void sendResponse(FileStoreRequestEvent requestEvent, boolean success, String error) {

        FileStoreResponseEvent response = FileStoreResponseEvent.builder()
                .sagaId(requestEvent.sagaId())
                .success(success)
                .projectId(requestEvent.projectId())
                .errorMessage(error)
                .build();

        kafkaTemplate.send("file-store-responses", response);
    }

}
