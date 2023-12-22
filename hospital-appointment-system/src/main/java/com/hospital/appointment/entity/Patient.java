package com.hospital.appointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    // TODO: 09/12/2023 a.Roles field b.security implementation c.Authorities
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String patientName;
    private String patientEmail;
    private String phoneNumber;

    @Column(name = "Gender")
    private String sex;

    @Column(name = "password")
    private String psw;
}
