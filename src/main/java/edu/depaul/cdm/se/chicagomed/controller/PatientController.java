package edu.depaul.cdm.se.chicagomed.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.Patient;
import edu.depaul.cdm.se.chicagomed.repository.AppoinmentRepository;
import edu.depaul.cdm.se.chicagomed.repository.DoctorRepository;
import edu.depaul.cdm.se.chicagomed.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;


@Controller
public class PatientController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppoinmentRepository appoinmentRepository;


    @GetMapping("/patient-appointment")
    public String getPatientAppointments(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        if (patient.isPresent()) {
            List<Appointment> appts = appoinmentRepository.findAllByPatient(patient.get());
            model.addAttribute("patient", patient.get());
            model.addAttribute("appts", appts);
            return "patient-appointment";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Patient not found");
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