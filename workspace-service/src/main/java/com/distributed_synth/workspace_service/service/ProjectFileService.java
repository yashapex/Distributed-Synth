package com.distributed_synth.workspace_service.service;


import com.distributed_synth.common_library.dto.FileTreeDto;
import com.distributed_synth.workspace_service.dto.project.FileContentResponse;
import org.apache.hc.core5.http.nio.FileContentDecoder;

public interface ProjectFileService {
    FileTreeDto getFileTree(Long projectId);

    String getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);

}
