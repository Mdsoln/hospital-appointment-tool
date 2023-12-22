package com.hospital.appointment.controller;

import com.hospital.appointment.dto.AppointmentRequest;
import com.hospital.appointment.dto.AppointmentsPerDate;
import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.entity.Doctor;
import com.hospital.appointment.entity.Patient;
import com.hospital.appointment.service.serviceImpl.AppointmentImpl;
import com.hospital.appointment.service.serviceImpl.AuthenticationFacade;
import com.hospital.appointment.service.serviceImpl.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/appointments")
@RestController
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentImpl appointmentService;
    private final DoctorServiceImpl doctorService;
    private final AuthenticationFacade authenticationFacade;

    @GetMapping("/doctors/{doctorSpecialist}")
    public ResponseEntity<List<Doctor>> searchListOfDoctorsBySpecialist(
          @PathVariable("doctorSpecialist") String doctorSpecialist
    ){
       List<Doctor> doctor = doctorService.findDoctorByHisHerSpecialist(doctorSpecialist);
       return ResponseEntity.ok(doctor);
    }

    @PostMapping("/make")
    public ResponseEntity<String> makeAppointmentForLoggedUser(
            @RequestBody AppointmentRequest request
    ){
        Patient patient = authenticationFacade.getAuthenticatedPatient();
        if (patient == null){
            return new ResponseEntity<>("User not authenticated", HttpStatus.UNAUTHORIZED);
        }

        Long doctorId = request.getDoctorId();
        Doctor doctor= doctorService.findDoctorById(doctorId);
        if (doctor == null){
            return new ResponseEntity<>("Doctor not found",HttpStatus.NOT_FOUND);
        }

        int appointment_slots = doctorService.numberOfAppointmentSlots(doctorId);
        if (appointment_slots <= 0){
            return new ResponseEntity<>("No available slots for this doctor",HttpStatus.BAD_REQUEST);
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setDate(currentDateTime.toLocalDate());
        appointment.setTime(currentDateTime.toLocalTime());

        appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>("Appointment made successfully",HttpStatus.OK);
    }

    @GetMapping("/viewAppointment")
    public ResponseEntity<Object> viewAppointment(
            LocalDate date
    ){
        AppointmentsPerDate views = appointmentService.appointmentsPerDate(date);
       return new ResponseEntity<>(views,HttpStatus.OK);
    }
}


/*
   DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM"); // Example: 02-Aug
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");   // Example: 14:30

        String formattedDate = currentDateTime.format(dateFormatter);
        String formattedTime = currentDateTime.format(timeFormatter);
*/
