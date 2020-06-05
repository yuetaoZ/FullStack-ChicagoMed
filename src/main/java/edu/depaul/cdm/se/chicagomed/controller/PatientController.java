package edu.depaul.cdm.se.chicagomed.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.*;
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
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorContactRepository doctorContactRepository;
    @Autowired
    private LocationRepository locationRepository;


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
            NewAppointment newAppointment = new NewAppointment();
            newAppointment.setPatientId(patientId);
            model.addAttribute("newAppointment", newAppointment);
            return "new-appointment";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Unable to schedule new appointment");
    }

    @GetMapping("/location-view")
    public String getLocationview(Model model){return "location-view";}

    @GetMapping("/list-locations")
    public String getListLocations(Model model){
        Iterable<Location> locs = locationRepository.findAll();
        model.addAttribute("locs",locs);
        return "list-locations";
    }

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
    public String getDoctorView(Model model){return "doctor-view";}
    //TODO
//    public String getDoctorView(@RequestParam(name = "doctorId", required = false, defaultValue = "none")String doctorId,  Model model){
//        long docId = Long.parseLong(doctorId);
//        Optional<DoctorContact> contact = doctorContactRepository.findById(docId);
//        if (contact.isPresent()){
//            model.addAttribute("contact",contact);
//            return "doctor-view";
//        }
//        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctor not found!");
//    }

    @GetMapping("/review-page")
    public String getReview(Model model){return "review-page";}

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

//    @GetMapping(path="/new-appointment", params = "add")
//    public String add(@RequestParam Long id) {
//        Appointment appointment = appoinmentRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("Invalid Appointment ID:" + id)
//        );
//        appoinmentRepository.save(appointment);
//        return "redirect:/patient-appointment" + appointment.getPatient().getPatientId();
//    }


    @PostMapping("/new-appointment")
    public String saveNewAppointment(@ModelAttribute("newAppointment") NewAppointment newAppointment, BindingResult bindingResult) {
        Appointment appointment = new Appointment();
        Optional<Patient> patient = patientRepository.findById(Long.parseLong(newAppointment.getPatientId()));
        if (patient.isPresent()) {
            appointment.setPatient(patient.get());
        }
        Optional<Doctor> doctor = doctorRepository.findById(Long.parseLong(newAppointment.getDoctorId()));
        if (doctor.isPresent()) {
            appointment.setDoctor(doctor.get());
        }
        Optional<Location> location = locationRepository.findById(Long.parseLong(newAppointment.getLocationId()));
        if (location.isPresent()) {
            appointment.setLocation(location.get());
        }
        appointment.setAppointmentDate(newAppointment.getApptDateTime());
        appoinmentRepository.save(appointment);
        return "redirect:/patient-appointment?patientId="+ newAppointment.getPatientId();
    }

}