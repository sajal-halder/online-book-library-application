package com.sajal.onlinebooklibraryapplication.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class GenericErrorResponse {
    private HttpStatus status;
    private String message;
}
