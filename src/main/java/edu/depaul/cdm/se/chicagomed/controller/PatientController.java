package edu.depaul.cdm.se.chicagomed.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.DoctorContact;
import edu.depaul.cdm.se.chicagomed.model.Patient;
import edu.depaul.cdm.se.chicagomed.repository.AppoinmentRepository;
import edu.depaul.cdm.se.chicagomed.repository.DoctorContactRepository;
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
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorContactRepository doctorContactRepository;


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


    @GetMapping("/list-doctors")
    public String getListDoctors(Model model){
        Iterable<Doctor> docs = doctorRepository.findAll();
        model.addAttribute("docs",docs);
        return "list-doctors";
    }
//    public String getListDoctors(@RequestParam(name = "doctorId", required = false, defaultValue = "none") String doctorId, Model model) {
//        long docId = Long.parseLong(doctorId);
//        Optional<Doctor> doctor = doctorRepository.findById(docId);
//        if (doctor.isPresent()) {
//            List<Doctor> docs = doctorRepository.findAll();
//            model.addAttribute("docs",docs);
//            return "list-doctors";
//        }
//        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctors not found!");
//    }

    @GetMapping("/doctor-View")
    public String getDoctorView(@RequestParam(name = "doctorId", required = false, defaultValue = "none")String doctorId,  Model model){
        long docId = Long.parseLong(doctorId);
        Optional<DoctorContact> contact = doctorContactRepository.findById(docId);
        if (contact.isPresent()){
            model.addAttribute("contact",contact);
            return "doctor-view";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctor not found!");
    }

    @GetMapping("/review-page")
    public String getReview(Model model){return "review-page";}

//    @GetMapping("/doctor-schedule")
//    public String getDoctorSchedule(Model model) {
//        return "doctor-schedule";
//    }


}