package com.sajal.onlinebooklibraryapplication.controller;

import com.sajal.onlinebooklibraryapplication.dto.CustomErrorResponse;
import com.sajal.onlinebooklibraryapplication.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookAlreadyExistException.class,BookNotFoundException.class, RoleDoesNotExistException.class, UserAlreadyExistException.class, UserCredentialException.class, BadCredentialsException.class,RoleDoesNotExistException.class})
    public ResponseEntity<Object> handleException(Exception exception) {
        if(exception instanceof UserAlreadyExistException) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.ALREADY_REPORTED));
        } else if(exception instanceof UserCredentialException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.UNAUTHORIZED));
        } else if(exception instanceof BookNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND));
        } else if(exception instanceof BookAlreadyExistException) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.ALREADY_REPORTED));
        } else if(exception instanceof RoleDoesNotExistException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND));
        }else if(exception instanceof BadCredentialsException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.UNAUTHORIZED));
        }
        else {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomErrorResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
