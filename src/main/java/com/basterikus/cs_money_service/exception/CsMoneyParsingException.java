package com.basterikus.cs_money_service.exception;

public class CsMoneyParsingException extends RuntimeException {
    public CsMoneyParsingException(Exception e) {
        super(e);
    }
}
