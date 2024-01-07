package com.example.product.exception;


public class Custom  extends RuntimeException {

    public Custom(String exceptionMessage){
        super(exceptionMessage);
    }
}
