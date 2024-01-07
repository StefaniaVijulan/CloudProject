package com.example.order.exception;


public class Custom  extends RuntimeException {

    public Custom(String exceptionMessage){
        super(exceptionMessage);
    }
}
