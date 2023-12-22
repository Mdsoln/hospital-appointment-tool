package com.hospital.appointment.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDto {
    private String firstName;
    private String lastName;
    private String specialist;
    private String room;
    private String email;
    private String gender;
    private String mobile;
    private DayOfWeek dayOfWeek;
    private LocalTime startHoursOfWork;
    private LocalTime endHoursOfWork;

    public void setStartHoursOfWorkString(String startHoursOfWorkString) {
        this.startHoursOfWork = LocalTime.parse(startHoursOfWorkString);
    }

    public void setEndHoursOfWorkString(String endHoursOfWorkString) {
        this.endHoursOfWork = LocalTime.parse(endHoursOfWorkString);
    }
}
