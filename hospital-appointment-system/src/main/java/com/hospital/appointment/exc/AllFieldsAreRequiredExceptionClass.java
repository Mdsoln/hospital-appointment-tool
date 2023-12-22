package com.hospital.appointment.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AllFieldsAreRequiredExceptionClass {
    private String message;
    private Throwable cause;
    private HttpStatus httpStatus;
}
