package com.distributed_synth.intelligence_service.dto.chat;


import com.distributed_synth.common_library.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
