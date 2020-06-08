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
    private DoctorReviewRepository doctorReviewRepository;
    @Autowired
    private LocationDocRepository locationDocRepository;
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationReviewRepository locationReviewRepository;


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
    public String getLocationview(@RequestParam(name = "locationId", required = false, defaultValue = "none")String locationId,@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model){
        long locId = Long.parseLong(locationId);
        Optional<Location> location = locationRepository.findById(locId);
        long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        if (location.isPresent()){
            Optional<LocationReview> reviews = locationReviewRepository.findById(locationId);
            model.addAttribute("location",location.get());
            model.addAttribute("patient",patient.get());
            model.addAttribute("reviews",reviews.orElseGet(() -> new LocationReview(locationId,"No Reviews")));
            return "location-view";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Location not found!");
    }

    @GetMapping("/list-locations")
    public String getListLocations(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model){
        long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        if (patient.isPresent()){
            model.addAttribute("patient",patient.get());
            Iterable<Location> locs = locationRepository.findAll();
            model.addAttribute("locs",locs);
            return "list-locations";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Locations not found!");
    }

    @GetMapping("/list-doctors")
    public String getListDoctors(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId,Model model){
       long patId = Long.parseLong(patientId);
       Optional<Patient> patient = patientRepository.findById(patId);
       if (patient.isPresent()){
           Iterable<Doctor> docs = doctorRepository.findAll();
           model.addAttribute("patient",patient.get());
           model.addAttribute("docs",docs);
           return "list-doctors";
       }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctors not found!");
    }

    @GetMapping("/doctor-view")
    public String getDoctorView(@RequestParam(name = "doctorId", required = false, defaultValue = "none")String doctorId,@RequestParam(name = "patientId", required = false, defaultValue = "none")String patientId,  Model model){
        long docId = Long.parseLong(doctorId);
        Optional<Doctor> doctor = doctorRepository.findById(docId);
        long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        if (doctor.isPresent()){
            List<DoctorContact> contact = doctorContactRepository.findByDoctor(doctor.get());
            List<DoctorSpecialization> specialization = doctorSpecializationRepository.findByDoctor(doctor.get());
            Optional<DoctorReview> reviews = doctorReviewRepository.findById(doctorId);
            model.addAttribute("patient",patient.get());
            model.addAttribute("doctor",doctor.get());
            model.addAttribute("contact",contact);
            model.addAttribute("specialization",specialization);
            model.addAttribute("reviews",reviews.orElseGet(() -> new DoctorReview(doctorId,"No Reviews")));
            return "doctor-view";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctor contact not found!");
    }

    @GetMapping("/review-page")
    public String getReview(@RequestParam(name = "doctorId", required = false, defaultValue = "none")String doctorId,@RequestParam(name = "patientId", required = false, defaultValue = "none")String patientId,  Model model){
        long docId = Long.parseLong(doctorId);
        Optional<Doctor> doctor = doctorRepository.findById(docId);
        long patId = Long.parseLong(patientId);
        Optional<Patient> patient = patientRepository.findById(patId);
        DoctorReview doctorReview = new DoctorReview(doctorId,"");
        doctorReview.setPatientId(patientId);
        if (doctor.isPresent()){
            model.addAttribute("doctor",doctor.get());
            model.addAttribute("patient",patient.get());
            model.addAttribute("doctorReview", doctorReview);
            return "review-page";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doctor contact not found!");
    }

    @PostMapping("/doctorReview-page")
    public String saveDoctorReview(@ModelAttribute("doctorReview") DoctorReview doctorReview, BindingResult bindingResult){
//        long patId = Long.parseLong(patientId);
        doctorReviewRepository.save(doctorReview);
        return "redirect:/list-doctors?patientId=" + doctorReview.getPatientId();
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