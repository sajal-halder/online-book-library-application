package com.sajal.onlinebooklibraryapplication.controller;

import com.sajal.onlinebooklibraryapplication.dto.LoginRequest;
import com.sajal.onlinebooklibraryapplication.dto.LoginResponse;
import com.sajal.onlinebooklibraryapplication.dto.RegisterRequest;
import com.sajal.onlinebooklibraryapplication.dto.RegisterResponse;
import com.sajal.onlinebooklibraryapplication.service.BindingService;
import com.sajal.onlinebooklibraryapplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final BindingService bindingService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody RegisterRequest registerRequest, BindingResult bindingResult){
        ResponseEntity<Object> errors = bindingService.getBindingError(bindingResult);
        if (errors != null) return errors;
        RegisterResponse registerResponse = userService.registerUser(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }



    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult){
        ResponseEntity<Object> errors = bindingService.getBindingError(bindingResult);
        if (errors != null) return errors;
        LoginResponse loginResponse = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

}
