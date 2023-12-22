package com.hospital.appointment.controller;

import com.hospital.appointment.dto.DoctorDto;
import com.hospital.appointment.service.serviceImpl.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorServiceImpl doctorService;
    @PostMapping("/add")
    public ResponseEntity<String> addDoctorToDatabase(
            @RequestBody DoctorDto doctorDto
    ){
        doctorService.saveDoctorDetails(doctorDto);
        return ResponseEntity.ok("Doctor details saved successfully");
    }

   @GetMapping("/search/{doctorName}")
   public ResponseEntity<DoctorDto> findDoctorByHisHerSpecialist(
        @PathVariable("doctorName") String doctorName
   ){
      DoctorDto doctorDto = doctorService.findDoctorByHisHerName(doctorName);
      if (doctorDto == null){
          return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(doctorDto,HttpStatus.OK);
   }
}
