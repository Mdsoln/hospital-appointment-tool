package com.hospital.appointment.dto;

import com.hospital.appointment.entity.Doctor;
import com.hospital.appointment.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentsPerDate {
    private Doctor doctor;
    private Patient patient;
    private LocalTime time;
}
