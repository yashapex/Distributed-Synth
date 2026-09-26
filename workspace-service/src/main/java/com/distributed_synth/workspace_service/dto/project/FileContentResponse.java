package com.distributed_synth.workspace_service.dto.project;

public record FileContentResponse(
        String path,
        String content
) {
}
