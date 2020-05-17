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

    @GetMapping("/location-view")
    public String getLocationview(Model model){return "location-view";}

    @GetMapping("/doctor-view")
    public String getDoctorview(Model model){return "doctor-view";}

    @GetMapping("/review-page")
    public String getReview(Model model){return "review-page";}

//    @GetMapping("/doctor-schedule")
//    public String getDoctorSchedule(Model model) {
//        return "doctor-schedule";
//    }


}
