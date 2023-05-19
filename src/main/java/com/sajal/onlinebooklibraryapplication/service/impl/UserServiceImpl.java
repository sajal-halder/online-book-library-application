package com.sajal.onlinebooklibraryapplication.service.impl;

import com.sajal.onlinebooklibraryapplication.dto.LoginRequest;
import com.sajal.onlinebooklibraryapplication.dto.LoginResponse;
import com.sajal.onlinebooklibraryapplication.dto.RegisterRequest;
import com.sajal.onlinebooklibraryapplication.dto.RegisterResponse;
import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import com.sajal.onlinebooklibraryapplication.entity.UserEntity;
import com.sajal.onlinebooklibraryapplication.exception.UserAlreadyExistException;
import com.sajal.onlinebooklibraryapplication.repository.UserRepository;
import com.sajal.onlinebooklibraryapplication.service.JwtService;
import com.sajal.onlinebooklibraryapplication.service.RoleService;
import com.sajal.onlinebooklibraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.sajal.onlinebooklibraryapplication.values.Messages.USER_REGISTER_SUCCESS;
import static com.sajal.onlinebooklibraryapplication.values.Messages.USER_WITH_EMAIL_EXIST;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new UserAlreadyExistException(USER_WITH_EMAIL_EXIST);
        }
        Set<RoleEntity> roles = new HashSet<>();
        registerRequest.getRoles().forEach(value-> roles.add(roleService.getRole(value)));
        UserEntity user = UserEntity.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .address(registerRequest.getAddress())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(roles)
                .build();

        UserEntity userEntity = userRepository.save(user);
        return RegisterResponse.builder()
                .id(userEntity.getUserId())
                .email(userEntity.getEmail())
                .message(USER_REGISTER_SUCCESS)
                .build();
    }



    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {

        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        String jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(loginRequest.getEmail()));

        return LoginResponse.builder()
                .token(jwtToken)
                .build();

    }
}
