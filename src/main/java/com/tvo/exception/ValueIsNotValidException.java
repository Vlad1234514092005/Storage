package com.tvo.exception;

public class ValueIsNotValidException extends RuntimeException{
    public ValueIsNotValidException(String message){
        super(message);
    }
}
