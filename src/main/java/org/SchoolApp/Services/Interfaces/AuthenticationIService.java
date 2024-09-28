package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Request.LoginUserDto;
import org.SchoolApp.Web.Dtos.Request.RegisterUserDto;
import org.SchoolApp.Web.Dtos.Request.UserRequestDto;

public interface AuthenticationIService {
    public UserEntity signup(UserRequestDto input);


    public UserEntity authenticate(LoginUserDto input);

}