package edu.depaul.cdm.se.chicagomed.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.AppoinmentRepository;
import edu.depaul.cdm.se.chicagomed.repository.DoctorRepository;
import edu.depaul.cdm.se.chicagomed.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String getNewAppointment(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        if (patient.isPresent()) {
            List<Appointment> appts = appoinmentRepository.findAllByPatient(patient.get());
            model.addAttribute("patient", patient.get());
            model.addAttribute("appts", appts);
            return "new-appointment";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Unable to schedule new appointment");
    }

    @GetMapping("/location-view")
    public String getLocationview(Model model){return "location-view";}

    @GetMapping("/doctor-view")
    public String getDoctorview(Model model){return "doctor-view";}

    @GetMapping("/review-page")
    public String getReview(Model model){return "review-page";}

    @PostMapping("/new-appointment")
    public String saveNewAppointment(@ModelAttribute("NewAppointment") NewAppointment newAppointment, BindingResult bindingResult) {
        //apptNotesRepository.save(apptNotes);
        return "redirect:/patient-appointment?patientId=";
    }

//    @GetMapping("/doctor-schedule")
//    public String getDoctorSchedule(Model model) {
//        return "doctor-schedule";
//    }

    @GetMapping(path="/cancel-appointment", params = "delete")
    public String delete(@RequestParam Long id) {
        Appointment appointment = appoinmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Appointment ID:" + id)
        );
        appoinmentRepository.delete(appointment);
        return "redirect:/patient-appointment?patientId=" + appointment.getPatient().getPatientId();
    }

}