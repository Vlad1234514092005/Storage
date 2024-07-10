package com.tvo.exception;

import java.security.PublicKey;

public class QuantityUnderZeroException extends RuntimeException{
    public QuantityUnderZeroException(String message){
        super(message);
    }
}
