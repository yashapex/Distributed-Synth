package com.distributed_synth.account_service.dto.subscription;

import com.distributed_synth.common_library.dto.PlanDto;

import java.time.Instant;

public record SubscriptionResponse(
        PlanDto plan,
        String status,
        Instant currentPeriodEnd,
        Long tokensUsedThisCycle
) {
}
