package edu.depaul.cdm.se.chicagomed.controller;

import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.PatientDOBRepository;
import edu.depaul.cdm.se.chicagomed.repository.PatientRepository;
import edu.depaul.cdm.se.chicagomed.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PatientDOBRepository patientDOBRepository;

    @GetMapping("admin-patients")
    public String getPatients(@RequestParam(name = "adminId", required = false, defaultValue = "none") String adminId, Model model) {
        Long admId = Long.parseLong(adminId);
        Optional<Admin> admin = adminRepository.findById(admId);
        if (admin.isPresent()) {
            Iterable<Patient> patients = patientRepository.findAll();
            model.addAttribute("admin", admin);
            model.addAttribute("patients", patients);

            return "admin-patients";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Admin not found");
    }



    @GetMapping("/admin-patientInfo")
    public String getPatientInfo(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Optional<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
        Optional<PatientDOB> patientDOB = patientDOBRepository.findById(Long.parseLong(patientId));
        if (patient.isPresent()) {
            model.addAttribute("patient", patient);
            model.addAttribute("patientDOB", patientDOB);

            return "admin-patientInfo";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Patient not found");
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
