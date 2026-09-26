package com.distributed_synth.intelligence_service.consumer;

import com.distributed_synth.common_library.enums.ChatEventStatus;
import com.distributed_synth.common_library.event.FileStoreResponseEvent;
import com.distributed_synth.intelligence_service.repository.ChatEventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntelligenceSagaResponseHandler {
    private final ChatEventRepository chatEventRepository;

    @Transactional
    @KafkaListener(topics = "file-store-responses", groupId = "intelligence-group")
    public void handleSagaResponse(FileStoreResponseEvent response){

        chatEventRepository.findBySagaId(response.sagaId()).ifPresent(event -> {
            if(!ChatEventStatus.PENDING.equals(event.getStatus())){
                log.info("Response for Saga {} already handled. Skipping.", response.sagaId());
                return;
            }

            if(response.success()){
                event.setStatus(ChatEventStatus.CONFIRMED);
                log.info("Saga {} confirmed", response.sagaId());
            }

            else{
                log.warn("Saga {} FAILED, Detecting event.", response.sagaId());
                event.setStatus(ChatEventStatus.CONFIRMED);
            }
        });
    }
}
