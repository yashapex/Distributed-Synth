package com.distributed_synth.intelligence_service.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class ChatSessionId implements Serializable {
    Long projectId;
    Long userId;
}
