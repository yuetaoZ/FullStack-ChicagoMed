package edu.depaul.cdm.se.chicagomed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @GetMapping("/patient-appointments")
    public String getPatientAppointments(Model model) {
        return "patient-appointments";
    }

//    @GetMapping("/doctor-appointment")
//    public String getDoctorAppointment(Model model) {
//        return "doctor-appointment";
//    }

//    @GetMapping("/doctor-schedule")
//    public String getDoctorSchedule(Model model) {
//        return "doctor-schedule";
//    }


}
