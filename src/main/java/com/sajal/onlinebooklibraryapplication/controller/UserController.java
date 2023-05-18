package com.sajal.onlinebooklibraryapplication.controller;

import com.sajal.onlinebooklibraryapplication.dto.LoginRequest;
import com.sajal.onlinebooklibraryapplication.dto.LoginResponse;
import com.sajal.onlinebooklibraryapplication.dto.RegisterRequest;
import com.sajal.onlinebooklibraryapplication.dto.RegisterResponse;
import com.sajal.onlinebooklibraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = userService.registerUser(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

}
