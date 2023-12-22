package com.hospital.appointment.service.serviceImpl;

import com.hospital.appointment.dto.AppointmentsPerDate;
import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.repo.AppointmentRepo;
import com.hospital.appointment.service.serviceInterface.AppointmentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AppointmentImpl implements AppointmentInterface {

    private final AppointmentRepo appointmentRepo;

    @Override
    public void saveAppointment(Appointment appointment) {
        Appointment appointment1 = new Appointment();
        appointment1.setDoctor(appointment.getDoctor());
        appointment1.setPatient(appointment.getPatient());
        appointment1.setDate(appointment.getDate());
        appointment1.setTime(appointment.getTime());

        appointmentRepo.save(appointment1);
    }

    /*api for admin to know the number of appointments made per day*/
    @Override
    public AppointmentsPerDate appointmentsPerDate(LocalDate date) {
        Appointment appointment = appointmentRepo.findByDate(date);
        if (appointment != null){
            return new AppointmentsPerDate(
                    appointment.getDoctor(),
                    appointment.getPatient(),
                    appointment.getTime()
            );
        }
        return null;
    }
}
