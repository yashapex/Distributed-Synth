package com.distributed_synth.workspace_service.controller;

import com.distributed_synth.common_library.dto.FileTreeDto;
import com.distributed_synth.common_library.enums.ProjectPermission;
import com.distributed_synth.workspace_service.service.ProjectFileService;
import com.distributed_synth.workspace_service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/internal/v1/")
@RestController
public class InternalWorkspaceController {

    private final ProjectService projectService;
    private final ProjectFileService projectFileService;

    @GetMapping("/projects/{projectId}/files/tree")
    public FileTreeDto getFileTree(@PathVariable("projectId") Long projectId) {
        return projectFileService.getFileTree(projectId);
    }

    @GetMapping("/projects/{projectId}/files/content")
    public String getFileContent(@PathVariable("projectId") Long projectId, @RequestParam String path) {
        return projectFileService.getFileContent(projectId, path);
    }

    @GetMapping("/projects/{projectId}/permissions/check")
    public boolean checkProjectPermission(@PathVariable("projectId") Long projectId,
                                         @RequestParam ProjectPermission projectPermission) {
        return projectService.hasPermission(projectId, projectPermission);
    }

}
