package com.hospital.appointment.service.serviceImpl;

import com.hospital.appointment.dto.PatientDto;
import com.hospital.appointment.entity.Patient;
import com.hospital.appointment.repo.PatientRepo;
import com.hospital.appointment.service.serviceInterface.PatientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientImpl implements PatientInterface {
    private final PatientRepo patientRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Override
    public void saveNewPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientName(patientDto.getPatientName());
        patient.setPatientEmail(patientDto.getPatientEmail());
        patient.setSex(patientDto.getSex());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setPsw(passwordEncoder.encode(patientDto.getPsw()));

        patientRepo.save(patient);
    }
}
