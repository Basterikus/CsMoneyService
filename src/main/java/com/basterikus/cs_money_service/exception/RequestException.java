package com.basterikus.cs_money_service.exception;

public class RequestException extends RuntimeException{
    public RequestException(String e) {
        super(e);
    }
}
