package com.hospital.appointment.controller;

import com.hospital.appointment.dto.PatientDto;
import com.hospital.appointment.service.serviceImpl.PatientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientImpl patientService;
    @PostMapping("/save")
    public ResponseEntity<String> savePatientDetails(
            @RequestBody  PatientDto patientDto
    ){
        patientService.saveNewPatient(patientDto);
        return ResponseEntity.ok("You have booked appointment successfully");
    }


    // TODO: 08/12/2023 create an api for admin to view all patient details created their account


}
