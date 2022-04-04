package com.basterikus.CsMoneyService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CsMoneyParsingException.class})
    public ResponseEntity<ErrorDto> handleExceptionFromParsing(Exception e) {
        return new ResponseEntity<>(new ErrorDto(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({LimitRequestException.class})
    public ResponseEntity<ErrorDto> handleExceptionFromCsMoney(Exception e) {
        return new ResponseEntity<>(new ErrorDto(e.getLocalizedMessage()), HttpStatus.TOO_MANY_REQUESTS);
    }
}
