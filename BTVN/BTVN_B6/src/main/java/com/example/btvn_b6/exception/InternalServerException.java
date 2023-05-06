package com.example.btvn_b6.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class InternalServerException extends RuntimeException{

    private String message;

    private HttpStatus status;

    public InternalServerException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
