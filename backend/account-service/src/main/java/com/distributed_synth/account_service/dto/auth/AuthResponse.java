package com.distributed_synth.account_service.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
