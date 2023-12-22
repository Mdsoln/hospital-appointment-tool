package com.hospital.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PatientDto {
    private String patientName;
    private String patientEmail;
    private String phoneNumber;
    private String sex;
    private String psw;
}
