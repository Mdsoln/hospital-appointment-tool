package com.hospital.appointment.service.serviceImpl;

import com.hospital.appointment.dto.DoctorDto;
import com.hospital.appointment.entity.Doctor;
import com.hospital.appointment.exc.AllFieldsAreRequiredException;
import com.hospital.appointment.exc.EmailExistException;
import com.hospital.appointment.exc.UserNotFoundException;
import com.hospital.appointment.repo.DoctorRepo;
import com.hospital.appointment.service.serviceInterface.DoctorInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorInterface {
    private final DoctorRepo doctorRepo;
    @Override
    public void saveDoctorDetails(DoctorDto doctorDto) {
        if (doctorDto.getFirstName().isEmpty() || doctorDto.getLastName().isEmpty()|| 
                doctorDto.getEmail().isEmpty()|| doctorDto.getGender().isEmpty()||
                doctorDto.getRoom().isEmpty()|| doctorDto.getSpecialist().isEmpty()
                || doctorDto.getMobile().isEmpty()
        ){
            throw new AllFieldsAreRequiredException("All fields are required");
        }

        if (doctorRepo.findByEmail(doctorDto.getEmail()) != null){
            throw new EmailExistException("Already exits a user with email:"+doctorDto.getEmail());
        }
        else {
            Doctor doctor = getDoctor(doctorDto);
            doctorRepo.save(doctor);
        }
    }

    private static Doctor getDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setFullName(doctorDto.getFirstName() + " " + doctorDto.getLastName());
        doctor.setSpecialist(doctorDto.getSpecialist());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setRoom(doctorDto.getRoom());
        doctor.setGender(doctorDto.getGender());
        doctor.setMobile(doctorDto.getMobile());
        doctor.setDayOfWeek(doctorDto.getDayOfWeek());
        doctor.setStartHoursOfWork(doctorDto.getStartHoursOfWork());
        doctor.setEndHoursOfWork(doctorDto.getEndHoursOfWork());
//        every doctor has a default one slot for receiving an appointment per day
        doctor.setAppointment(1);
        return doctor;
    }

    @Override
    public DoctorDto findDoctorByHisHerName(String doctorName) {
        Doctor doctor = doctorRepo.findByFullName(doctorName);
        if (doctor != null){
            String[] name = doctor.getFullName().split(" ");
            return getDoctorDto(name, doctor);
        }
        else {
            throw new UserNotFoundException("Sorry! Doctor with specified funny does not exits");
        }
    }

    private static DoctorDto getDoctorDto(String[] name, Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setFirstName(name[0]);
        doctorDto.setLastName(name[1]);
        doctorDto.setSpecialist(doctor.getSpecialist());
        doctorDto.setRoom(doctor.getRoom());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setMobile(doctor.getMobile());
        doctorDto.setGender(doctor.getGender());
        doctorDto.setDayOfWeek(doctor.getDayOfWeek());
        doctorDto.setStartHoursOfWork(doctor.getStartHoursOfWork());
        doctorDto.setEndHoursOfWork(doctor.getEndHoursOfWork());
        return doctorDto;
    }

    @Override
    public List<Doctor> findDoctorByHisHerSpecialist(String doctorSpecialist) {
        return doctorRepo.findBySpecialist(doctorSpecialist);
    }


    @Override
    public Doctor findDoctorById(Long doctorId) {
        return doctorRepo.findByDoctorId(doctorId);
    }

    @Override
    public int numberOfAppointmentSlots(Long doctorId) {
        Doctor doctor = doctorRepo.findByDoctorId(doctorId);
        return doctor.getAppointment();
    }
}
