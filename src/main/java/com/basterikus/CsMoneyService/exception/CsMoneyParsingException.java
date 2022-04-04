package com.basterikus.CsMoneyService.exception;

public class CsMoneyParsingException extends RuntimeException {
    public CsMoneyParsingException(Exception e) {
        super(e);
    }
}
