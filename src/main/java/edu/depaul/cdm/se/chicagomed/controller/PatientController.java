package edu.depaul.cdm.se.chicagomed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @GetMapping("/patient-appointment")
    public String getPatientAppointments(Model model) {
        return "patient-appointment";
    }

    @GetMapping("/new-appointment")
    public String getNewAppointment(Model model) {
        return "new-appointment";
    }

//    @GetMapping("/doctor-schedule")
//    public String getDoctorSchedule(Model model) {
//        return "doctor-schedule";
//    }


}
