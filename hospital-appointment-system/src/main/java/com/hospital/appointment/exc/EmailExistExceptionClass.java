package com.hospital.appointment.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmailExistExceptionClass {
    private String message;
    private Throwable cause;
    private HttpStatus httpStatus;
}
