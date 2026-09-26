package com.distributed_synth.account_service.mapper;


import com.distributed_synth.account_service.dto.auth.SignupRequest;
import com.distributed_synth.account_service.dto.auth.UserProfileResponse;
import com.distributed_synth.account_service.entity.User;
import com.distributed_synth.common_library.dto.UserDto;
import com.distributed_synth.common_library.security.JwtUserPrincipal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    @Mapping(source = "userId", target = "id")
    UserProfileResponse toUserProfileResponse(JwtUserPrincipal user);

    UserDto toUserDto(User user);

}
