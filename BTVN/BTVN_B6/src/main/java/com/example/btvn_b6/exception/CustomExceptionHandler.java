package com.example.btvn_b6.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorRepone handlerNotFound(NotFoundException e){
        return new ErrorRepone(e.getMessage(), e.getStatus());
    }

    @ExceptionHandler(InternalServerException.class)
    public ErrorRepone handlerInternalServer(InternalServerException e){
        return new ErrorRepone(e.getMessage(), e.getStatus());
    }
}
