package edu.depaul.cdm.se.chicagomed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin-appointments")
    public String getDoctorAppointments(Model model) {
        return "admin-appointments";
    }

    @GetMapping("/admin-appointment")
    public String getDoctorAppointment(Model model) {
        return "admin-appointment";
    }
}
