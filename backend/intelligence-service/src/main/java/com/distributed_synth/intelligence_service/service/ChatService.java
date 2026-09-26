package com.distributed_synth.intelligence_service.service;



import com.distributed_synth.intelligence_service.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}
