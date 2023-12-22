package com.hospital.appointment.service.serviceInterface;

import com.hospital.appointment.dto.AppointmentsPerDate;
import com.hospital.appointment.entity.Appointment;

import java.time.LocalDate;

public interface AppointmentInterface {

    void saveAppointment(Appointment appointment);

    AppointmentsPerDate appointmentsPerDate(LocalDate date);

}
