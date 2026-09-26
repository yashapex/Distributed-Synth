package com.distributed_synth.workspace_service.dto.member;

import com.distributed_synth.common_library.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
