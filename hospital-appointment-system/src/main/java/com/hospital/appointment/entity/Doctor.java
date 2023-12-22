package com.hospital.appointment.entity;

import com.hospital.appointment.dto.DayOfWeek;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    // TODO: 09/12/2023 a.Roles and Authorities b.push notifications of made appointments c.doctor can view details of patient
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String fullName;
    private String specialist;
    private String room;
    private String email;
    private String gender;
    private String mobile;

//    this field used to hold appointment per day, sure its only one
    private int appointment;

    @Column(name = "day",nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "start",nullable = false)
    private LocalTime startHoursOfWork;

    @Column(name = "end",nullable = false)
    private LocalTime endHoursOfWork;
}
