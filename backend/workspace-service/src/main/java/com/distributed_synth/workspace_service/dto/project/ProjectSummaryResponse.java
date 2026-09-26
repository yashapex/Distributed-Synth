package com.distributed_synth.workspace_service.dto.project;


import com.distributed_synth.common_library.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
