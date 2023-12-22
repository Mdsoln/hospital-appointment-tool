package com.hospital.appointment.repo;

import com.hospital.appointment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findByFullName(String doctorName);

    List<Doctor> findBySpecialist(String doctorSpecialist);

    Doctor findByEmail(String email);

    Doctor findByDoctorId(Long doctorId);

}
