package com.sajal.onlinebooklibraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class CustomErrorResponse {
    private String message;
    private HttpStatus status;

}
