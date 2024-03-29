package com.msprices.exception;

public class PricesNotAvailableException extends RuntimeException{
    public PricesNotAvailableException(String message){
        super(message);
    }
}
