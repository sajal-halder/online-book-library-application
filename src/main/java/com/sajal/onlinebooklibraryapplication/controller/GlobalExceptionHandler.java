package com.sajal.onlinebooklibraryapplication.controller;

import com.sajal.onlinebooklibraryapplication.exception.BookNotFoundException;
import com.sajal.onlinebooklibraryapplication.exception.RoleDoesNotExistException;
import com.sajal.onlinebooklibraryapplication.exception.UserAlreadyExistException;
import com.sajal.onlinebooklibraryapplication.exception.UserCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class, RoleDoesNotExistException.class, UserAlreadyExistException.class, UserCredentialException.class})
    public ResponseEntity<Object> handleException(Exception exception) {
        if(exception instanceof UserAlreadyExistException) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
        } else if(exception instanceof UserCredentialException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
        }else {
             return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(exception.getMessage());
        }
    }

}
