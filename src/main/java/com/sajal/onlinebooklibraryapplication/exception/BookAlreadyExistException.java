package com.sajal.onlinebooklibraryapplication.exception;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(String message){
        super(message);
    }
}
