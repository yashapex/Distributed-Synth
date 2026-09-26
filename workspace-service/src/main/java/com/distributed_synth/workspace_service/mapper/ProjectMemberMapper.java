package com.distributed_synth.workspace_service.mapper;

import com.distributed_synth.workspace_service.dto.member.MemberResponse;
import com.distributed_synth.workspace_service.entity.ProjectMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

//    @Mapping(target = "userId", source = "id")
//    @Mapping(target = "projectRole", constant = "OWNER")
//    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "id.userId")
    @Mapping(target = "projectRole", source = "projectRole")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
