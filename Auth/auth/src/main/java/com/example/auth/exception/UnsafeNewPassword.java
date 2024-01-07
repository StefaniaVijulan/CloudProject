package com.example.auth.exception;


public class UnsafeNewPassword extends RuntimeException {

    public UnsafeNewPassword(String exceptionMessage){
        super(exceptionMessage);
    }
}
