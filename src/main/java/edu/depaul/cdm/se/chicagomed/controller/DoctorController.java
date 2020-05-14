package edu.depaul.cdm.se.chicagomed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @GetMapping("/doctor-appointments")
    public String getDoctorAppointments(Model model) {
        return "doctor-appointments";
    }

    @GetMapping("/doctor-appointment")
    public String getDoctorAppointment(Model model) {
        return "doctor-appointment";
    }

    @GetMapping("/doctor-schedule")
    public String getDoctorSchedule(Model model) {
        return "doctor-schedule";
    }
}
