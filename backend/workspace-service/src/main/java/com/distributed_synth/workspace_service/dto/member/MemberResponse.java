package com.distributed_synth.workspace_service.dto.member;


import com.distributed_synth.common_library.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
