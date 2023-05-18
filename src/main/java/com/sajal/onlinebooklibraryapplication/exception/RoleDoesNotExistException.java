package com.sajal.onlinebooklibraryapplication.exception;

public class RoleDoesNotExistException extends RuntimeException{
    public RoleDoesNotExistException(String message){
        super(message);
    }
}
