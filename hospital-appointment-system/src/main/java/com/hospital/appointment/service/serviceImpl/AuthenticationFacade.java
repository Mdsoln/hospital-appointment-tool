package com.hospital.appointment.service.serviceImpl;

import com.hospital.appointment.entity.Patient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/*This class used to get the logged-in user credentials e.g. email, id, and e.t.c*/
@Service
public class AuthenticationFacade {
    public Patient getAuthenticatedPatient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Patient){
            return (Patient) authentication.getPrincipal();
        }
        return null;
    }
}
