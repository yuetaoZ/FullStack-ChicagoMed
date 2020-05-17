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

    @GetMapping("/admin-patientInfo")
    public String getPatientInfo(Model model) {
        return "admin-patientInfo";
    }

    @GetMapping("/admin-patientInfo-edit")
    public String getPatientInfoEdit(Model model) {
        return "admin-patientInfo-edit";
    }

    @GetMapping("/admin-patient-appointments-history")
    public String getPatientAppointmentsHistory(Model model) {
        return "admin-patient-appointments-history";
    }

    @GetMapping("/admin-patient-upcoming-appointments")
    public String getPatientUpcomingAppointments(Model model) {
        return "admin-patient-upcoming-appointments";
    }

    @GetMapping("/admin-patient-upcoming-appointment-details")
    public String getPatientUpcomingAppointmentDetails(Model model) {
        return "admin-patient-upcoming-appointment-details";
    }

    @GetMapping("/admin-patient-appointment-details")
    public String getPatientAppointmentDetails(Model model) {
        return "admin-patient-appointment-details";
    }

    @GetMapping("/admin-patient-billing-info")
    public String getPatientBillingInfo(Model model) {
        return "admin-patient-billing-info";
    }
}
