package com.hospital.appointment.exc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllFieldsAreRequiredHandler {

    @ExceptionHandler(value = {AllFieldsAreRequiredException.class})
    public ResponseEntity<Object> handleOnceEitherOfTheFieldIsEmpty(
            AllFieldsAreRequiredException fieldsAreRequiredException
    ){
        AllFieldsAreRequiredExceptionClass fieldsAreRequiredExceptionClass = new AllFieldsAreRequiredExceptionClass(
                fieldsAreRequiredException.getMessage(),
                fieldsAreRequiredException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(fieldsAreRequiredExceptionClass,HttpStatus.BAD_REQUEST);
    }
}
