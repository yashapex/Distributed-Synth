package com.distributed_synth.workspace_service.mapper;

import com.distributed_synth.common_library.dto.FileNode;
import com.distributed_synth.workspace_service.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
