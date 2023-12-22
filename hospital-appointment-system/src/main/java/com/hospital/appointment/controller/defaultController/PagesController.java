package com.hospital.appointment.controller.defaultController;

import com.hospital.appointment.dto.PatientDto;
import com.hospital.appointment.service.serviceImpl.PatientImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/*MUDDY RAMADHAN FAKIH +255717611117 muddyfakih98@gmail.com */
@Controller
@RequiredArgsConstructor
public class PagesController {
    private final PatientImpl patientService;

//  default page for every user
    @GetMapping({"/","index"})
    public String indexPages(){
        return "index";
    }

//    default for all logged in user
    @GetMapping("/default")
    public String defaultPageForLoggedInUser(){
        return "/default";
    }

//    for logged-in users will be able to view my cv
    @GetMapping("/about")
    public String aboutMe(){
        return "about";
    }

//    registering patients
    @GetMapping("/patient")
    public String patientRegistering(Model model){
        PatientDto patientDto= new PatientDto();
        model.addAttribute("patient",patientDto);
        return "patient";
    }

    @PostMapping("/patient/save")
    public String savePatientDetails(
    @Valid @ModelAttribute("patient") PatientDto patientDto, BindingResult result,Model model
    ){
        if (result.hasErrors()){
            model.addAttribute("patient",patientDto);
            return "/patient";
        }
        patientService.saveNewPatient(patientDto);
        return "redirect:/patient?success";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}
