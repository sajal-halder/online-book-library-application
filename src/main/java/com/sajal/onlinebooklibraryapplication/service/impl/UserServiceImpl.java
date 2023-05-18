package com.sajal.onlinebooklibraryapplication.service.impl;

import com.sajal.onlinebooklibraryapplication.dto.LoginRequest;
import com.sajal.onlinebooklibraryapplication.dto.LoginResponse;
import com.sajal.onlinebooklibraryapplication.dto.RegisterRequest;
import com.sajal.onlinebooklibraryapplication.dto.RegisterResponse;
import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import com.sajal.onlinebooklibraryapplication.entity.UserEntity;
import com.sajal.onlinebooklibraryapplication.exception.UserAlreadyExistException;
import com.sajal.onlinebooklibraryapplication.exception.UserCredentialException;
import com.sajal.onlinebooklibraryapplication.repository.UserRepository;
import com.sajal.onlinebooklibraryapplication.service.RoleService;
import com.sajal.onlinebooklibraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new UserAlreadyExistException("User with email already exist");
        }
        Set<RoleEntity> roles = new HashSet<>();
        registerRequest.getRoles().forEach(value-> roles.add(roleService.getRole(value)));
        var user = UserEntity.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .roles(roles)
                .build();
        //TODO: add password encoder here

        UserEntity userEntity = userRepository.save(user);
        return RegisterResponse.builder()
                .id(userEntity.getUserId())
                .email(userEntity.getEmail())
                .message("User Registration success")
                .build();
    }



    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        var user = userRepository.findByEmail(loginRequest.getEmail());
        if(user.isEmpty()){
            throw new UserCredentialException("No User found with this email");
        }
        else {
            // TODO: add authentication here
        }

        return LoginResponse.builder()
                .token("static token")
                .email(user.get().getEmail())
                .build();

    }
}
