package com.hospital.appointment.repo;

import com.hospital.appointment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

    Patient findByPatientEmail(String username);

}
