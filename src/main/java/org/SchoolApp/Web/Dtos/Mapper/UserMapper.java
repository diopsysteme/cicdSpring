package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Request.UserRequestDto;
import org.SchoolApp.Web.Dtos.Response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserRequestDto dto);
    UserResponseDto toDto(UserEntity entity);
    UserRequestDto toRequestDto(UserEntity entity);

}