package com.distributed_synth.workspace_service.service;


import com.distributed_synth.workspace_service.dto.deploy.DeployResponse;
import jakarta.annotation.Nullable;

public interface DeploymentService {

    @Nullable
    DeployResponse deploy(Long projectId);
}
