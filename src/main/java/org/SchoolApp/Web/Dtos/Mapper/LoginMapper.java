package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Services.Interfaces.JwtServiceInterface;
import org.SchoolApp.Web.Dtos.Request.LoginUserDto;
import org.SchoolApp.Web.Dtos.Response.LoginResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    LoginResponse toDto(JwtServiceInterface jwtServiceInterface);
}
