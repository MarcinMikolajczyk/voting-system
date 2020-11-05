package com.marcin.voting.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidOperationExceptionAdvice {

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public InvalidOperationException InvalidOperationHandler(InvalidOperationException e) {
        return e;
    }
}
