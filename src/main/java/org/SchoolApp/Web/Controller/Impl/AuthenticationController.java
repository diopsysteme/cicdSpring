package org.SchoolApp.Web.Controller.Impl;


import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Services.Interfaces.AuthenticationIService;
import org.SchoolApp.Services.Interfaces.JwtServiceInterface;
import org.SchoolApp.Web.Dtos.Mapper.LoginMapper;
import org.SchoolApp.Web.Dtos.Request.LoginUserDto;
import org.SchoolApp.Web.Dtos.Request.UserRequestDto;
import org.SchoolApp.Web.Dtos.Response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtServiceInterface jwtService;

    private final AuthenticationIService authenticationService;
    private final LoginMapper  loginMapper;

    public AuthenticationController(JwtServiceInterface jwtService, AuthenticationIService authenticationService, LoginMapper loginMapper) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.loginMapper = loginMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody UserRequestDto registerUserDto) {
        System.out.println(registerUserDto);
        UserEntity registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        System.out.println(loginUserDto.toString());
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);
        System.out.println(loginUserDto.toString());
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = loginMapper.toDto(jwtService); // Map user details to DTO
        loginResponse.setToken(jwtToken); // Set the JWT token

        return ResponseEntity.ok(loginResponse);
    }
}