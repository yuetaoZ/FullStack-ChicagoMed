package edu.depaul.cdm.se.chicagomed.controller;

import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Date;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PatientContactRepository patientContactRepository;
    @Autowired
    private AppoinmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;



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
        Optional<PatientContact> patientContact = patientContactRepository.findById(Long.parseLong(patientId));
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            model.addAttribute("patientContact", patientContact.get());

            return "admin-patientInfo";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Patient not found");
    }

    @GetMapping("/admin-patientInfo-edit")
    public String getPatientInfoEdit(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Optional<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
        Optional<PatientContact> patientContact = patientContactRepository.findById(Long.parseLong(patientId));
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            model.addAttribute("patientContact", patientContact.get());

            return "admin-patientInfo-edit";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Patient not found");
    }

    @GetMapping("/admin-patient-appointments-history")
    public String getPatientAppointmentsHistory(Model model) {
        return "admin-patient-appointments-history";
    }

    @GetMapping("/admin-patient-upcoming-appointments")
    public String getPatientUpcomingAppointments(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Optional<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
        if (patient.isPresent()) {
            Iterable<Appointment> appointments = appointmentRepository.findAllByPatient(patient.get());
            model.addAttribute("patient", patient.get());
            model.addAttribute("appointments", appointments);

            return "admin-patient-upcoming-appointments";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appointments not found");
    }

    @GetMapping("/admin-patient-upcoming-appointment-details")
    public String getPatientUpcomingAppointmentDetails(@RequestParam(name = "appointmentId", required = false, defaultValue = "none") String appointmentId, Model model) {
        Optional<Appointment> appointment = appointmentRepository.findById(Long.parseLong(appointmentId));
        Optional<Patient> patient = patientRepository.findById(appointment.get().getPatient().getPatientId());
        Optional<Doctor> doctor = doctorRepository.findById(appointment.get().getDoctor().getDoctorId());
        if (appointment.isPresent()) {
            model.addAttribute("patient", patient.get());
            model.addAttribute("doctor", doctor.get());
            model.addAttribute("appointment", appointment.get());

            return "admin-patient-upcoming-appointment-details";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appointment not found");
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
