package com.hospital.appointment.exc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(
          UserNotFoundException userNotFoundException
    ){
        UserNotFoundExceptionClass userNotFoundExceptionClass = new UserNotFoundExceptionClass(
                userNotFoundException.getMessage(),
                userNotFoundException.getCause(),
                NOT_FOUND
        );
        return new ResponseEntity<>(userNotFoundExceptionClass, NOT_FOUND);
    }
}
