package com.distributed_synth.workspace_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "processed_events")
@AllArgsConstructor
@NoArgsConstructor
public class ProcessedEvent {

    @Id
    private String sagaId;
    private LocalDateTime processedAt;
}
