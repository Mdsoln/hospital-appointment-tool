package com.hospital.appointment.repo;

import com.hospital.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    Appointment findByDate(LocalDate date);
}
