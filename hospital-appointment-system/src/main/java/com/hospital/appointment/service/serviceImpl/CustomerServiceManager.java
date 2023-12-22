package com.hospital.appointment.service.serviceImpl;

import com.hospital.appointment.entity.Patient;
import com.hospital.appointment.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceManager implements UserDetailsService {
    // TODO: 09/12/2023 Roles and Authorities to logged-in user/patient
    // TODO: 09/12/2023 Session management for logged-in user/patient
    private final PatientRepo patientRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepo.findByPatientEmail(username);
        if (patient != null){
            return org.springframework.security.core.userdetails.User.withUsername(username)
                    .password(patient.getPsw())
                    .roles((String) null)
                    .build();
        }
        throw new UsernameNotFoundException("User does not exits!");
    }
}
