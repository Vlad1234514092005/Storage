package com.tvo.exception;

public class GoodNotFoundException extends RuntimeException{
    public GoodNotFoundException(String message){
        super(message);
    }
}
