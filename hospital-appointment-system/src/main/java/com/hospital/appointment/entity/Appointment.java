package com.hospital.appointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long appId;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @Column(name = "date",nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;
}
