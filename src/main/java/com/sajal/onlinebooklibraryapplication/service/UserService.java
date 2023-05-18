package com.sajal.onlinebooklibraryapplication.service;

import com.sajal.onlinebooklibraryapplication.dto.LoginRequest;
import com.sajal.onlinebooklibraryapplication.dto.LoginResponse;
import com.sajal.onlinebooklibraryapplication.dto.RegisterRequest;
import com.sajal.onlinebooklibraryapplication.dto.RegisterResponse;
import org.springframework.stereotype.Service;

public interface UserService {
    public RegisterResponse registerUser(RegisterRequest registerRequest);
    public LoginResponse loginUser(LoginRequest loginRequest);
}
