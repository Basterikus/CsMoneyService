package com.basterikus.CsMoneyService.exception;

public class LimitRequestException extends RuntimeException{
    public LimitRequestException(String e) {
        super(e);
    }
}
