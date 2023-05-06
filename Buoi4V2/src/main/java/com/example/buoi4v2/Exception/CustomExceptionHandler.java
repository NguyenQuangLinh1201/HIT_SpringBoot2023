package com.example.buoi4v2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.NotActiveException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ErrorResponse handlerArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex, WebRequest request){
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotActiveException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex, WebRequest request){
        System.out.println(ex.getMassage());
        return new ErrorResponse();
    }
}
