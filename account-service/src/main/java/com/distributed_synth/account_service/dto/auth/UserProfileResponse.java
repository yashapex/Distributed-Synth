package com.distributed_synth.account_service.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
