package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler
{
    @ExceptionHandler(PersonException.class)
    public ResponseEntity<ErrorInfo> handleException(PersonException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(PersonError.INCORRECT_DATA.equals(e.getPersonError())){
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getPersonError().getMessage()));
    }
}
