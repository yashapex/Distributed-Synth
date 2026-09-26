package com.distributed_synth.account_service.mapper;

import com.distributed_synth.account_service.dto.subscription.SubscriptionResponse;
import com.distributed_synth.account_service.entity.Plan;
import com.distributed_synth.account_service.entity.Subscription;
import com.distributed_synth.common_library.dto.PlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanDto toPlanResponse(Plan plan);
}
