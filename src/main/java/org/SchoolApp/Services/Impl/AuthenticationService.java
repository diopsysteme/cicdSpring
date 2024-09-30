package org.SchoolApp.Services.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.SchoolApp.Datas.Entity.Role;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Datas.Enums.StatusEnum;
import org.SchoolApp.Datas.Repository.RoleRepository;
import org.SchoolApp.Datas.Repository.UserRepository;
import org.SchoolApp.Exceptions.ResourceNotFoundException;
import org.SchoolApp.Services.Interfaces.AuthenticationIService;
import org.SchoolApp.Web.Dtos.Mapper.LoginMapper;
import org.SchoolApp.Web.Dtos.Mapper.UserMapper;
import org.SchoolApp.Web.Dtos.Request.LoginUserDto;
import org.SchoolApp.Web.Dtos.Request.RegisterUserDto;
import org.SchoolApp.Web.Dtos.Request.UserRequestDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationIService {
    private final UserRepository userRepository;
private UserMapper  userMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoginMapper loginMapper;
    private final AuthenticationManager authenticationManager;
   private final  RoleRepository roleRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            UserMapper userMapper,
            LoginMapper loginMapper,
            RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.loginMapper = loginMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserEntity signup(UserRequestDto input) {
        // Map DTO to UserEntity
        UserEntity user = userMapper.toEntity(input);

        // Set default values for fields not included in the DTO
        user.setStatus(StatusEnum.ACTIF); // Set default status to active
        user.setDeleted(false); // Default value for deleted
        user.setPassword(encodePassword(input.getPassword())); // Assuming you have a method to encode the password

        // Fetch the Role entity based on roleId
        Role role = roleRepository.findById(input.getRoleId())
                .orElseThrow(() ->  new ResourceNotFoundException("Role not found with ID: " + input.getRoleId()));
        user.setRole(role);

        // Save the user entity
        return userRepository.save(user);
    }

    // Assuming you have a password encoding method
    private String encodePassword(String password) {
        // Implement your password encoding logic here (e.g., BCrypt)
        return passwordEncoder.encode(password); // Example using BCryptPasswordEncoder
    }
@Override
    public UserEntity authenticate(LoginUserDto input) {
        System.out.println(input.toString());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();

    }
}
