package edu.depaul.cdm.se.chicagomed.controller;

import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.Patient;
import edu.depaul.cdm.se.chicagomed.model.PatientMedHistory;
import edu.depaul.cdm.se.chicagomed.repository.AppoinmentRepository;
import edu.depaul.cdm.se.chicagomed.repository.DoctorRepository;
import edu.depaul.cdm.se.chicagomed.repository.PatientMedHistoryRepository;
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
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppoinmentRepository appoinmentRepository;
    @Autowired
    private PatientMedHistoryRepository patientMedHistoryRepository;

    @GetMapping("/doctor-appointments")
    public String getDoctorAppointments(@RequestParam(name = "user", required = false, defaultValue = "none") String userId, Model model) {
        Long docId = Long.parseLong(userId);
        Optional<Doctor> doctor = doctorRepository.findById(docId);
        if (doctor.isPresent()) {
            List<Appointment> appts = appoinmentRepository.findAllByDoctor(doctor.get());
            model.addAttribute("appts", appts);
            return "doctor-appointments";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Doc not found");
    }

    @GetMapping("/doctor-appointment")
    public String getDoctorAppointment(@RequestParam(name = "apptId", required = false, defaultValue = "none") String apptId, Model model) {
        Optional<Appointment> appt = appoinmentRepository.findById(Long.parseLong(apptId));
        if (appt.isPresent()) {
            Patient patient = appt.get().getPatient();
            Optional<PatientMedHistory> patientMedHistory = patientMedHistoryRepository.findById(patient.getPatientId());
            model.addAttribute("patient", appt.get().getPatient());
            patientMedHistory.ifPresent(medHistory -> model.addAttribute("patientMedHistory", medHistory.getMedicalHistory()));
            return "doctor-appointment";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appt not found");
    }

    @GetMapping("/doctor-schedule")
    public String getDoctorSchedule(Model model) {
        return "doctor-schedule";
    }
}
