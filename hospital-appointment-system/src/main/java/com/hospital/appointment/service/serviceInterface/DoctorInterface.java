package com.hospital.appointment.service.serviceInterface;

import com.hospital.appointment.dto.DoctorDto;
import com.hospital.appointment.entity.Doctor;

import java.util.List;

public interface DoctorInterface {
    void saveDoctorDetails(DoctorDto doctorDto);
    List<Doctor> findDoctorByHisHerSpecialist(String doctorSpecialist);
    DoctorDto findDoctorByHisHerName(String doctorName);

    Doctor findDoctorById(Long doctorId);

    int numberOfAppointmentSlots(Long doctorId);

}
