package com.hospital.appointment.exc;

public class AllFieldsAreRequiredException extends RuntimeException{

    public AllFieldsAreRequiredException(String message) {
        super(message);
    }

    public AllFieldsAreRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
