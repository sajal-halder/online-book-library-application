package com.sajal.onlinebooklibraryapplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String email;
    private String message;
}
