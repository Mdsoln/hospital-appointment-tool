package com.hospital.appointment.exc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmailExistExceptionHandler {
    @ExceptionHandler(value = {EmailExistException.class})
    public ResponseEntity<Object> handleOnceEmailRepeated(
        EmailExistException emailExistException
    ){
        EmailExistExceptionClass emailExistExceptionClass = new EmailExistExceptionClass(
                emailExistException.getMessage(),
                emailExistException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(emailExistExceptionClass,HttpStatus.BAD_REQUEST);
    }
}
