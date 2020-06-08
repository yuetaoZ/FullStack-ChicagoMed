package edu.depaul.cdm.se.chicagomed.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.*;
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

import javax.management.ObjectName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppoinmentRepository appoinmentRepository;
    @Autowired
    private PatientMedHistoryRepository patientMedHistoryRepository;
    @Autowired
    private ApptNotesRepository apptNotesRepository;
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    @GetMapping("/doctor-appointments")
    public String getDoctorAppointments(@RequestParam(name = "doctorId", required = false, defaultValue = "none") String doctorId, Model model) {
        Long docId = Long.parseLong(doctorId);
        Optional<Doctor> doctor = doctorRepository.findById(docId);
        if (doctor.isPresent()) {
            List<Appointment> appts = appoinmentRepository.findAllByDoctor(doctor.get());
            model.addAttribute("doctor", doctor.get());
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
            patientMedHistory.ifPresentOrElse(medHistory -> model.addAttribute("patientMedHistory", medHistory.getMedicalHistory()), () -> model.addAttribute("patientMedHistory", ""));

            Optional<ApptNotes> apptNotes = apptNotesRepository.findById(appt.get().getAppointmentId());
            if (apptNotes.isPresent()) {
                model.addAttribute("apptNotes", apptNotes.get());
            } else {
                ApptNotes newNotes = new ApptNotes();
                newNotes.setAppointmentId(Long.parseLong(apptId));
                model.addAttribute("apptNotes", newNotes);
            }
            return "doctor-appointment";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appt not found");
    }

    @PostMapping("/appointment-notes")
    public String saveAppointmentNotes(@ModelAttribute("apptNotes") ApptNotes apptNotes, BindingResult bindingResult) {
        apptNotesRepository.save(apptNotes);
        return "redirect:/doctor-appointment?apptId=" + apptNotes.getAppointmentId();
    }

    @GetMapping("/doctor-schedule")
    public String getDoctorSchedule(@RequestParam(name = "doctorId", required = false, defaultValue = "none") String doctorId, Model model) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(Long.parseLong(doctorId));
        model.addAttribute("doctor", doctor.get());
        Optional<DoctorSchedule> doctorSchedule = doctorScheduleRepository.findById(doctor.get().getDoctorId());
        if (doctorSchedule.isPresent()) {
            model.addAttribute("docSchedule", doctorSchedule.get());
        } else {
            DoctorSchedule newSchedule = new DoctorSchedule();
            newSchedule.setDoctorId(Long.parseLong(doctorId));
            newSchedule.setSchedule(WeekSchedule.getDefaultSchedule());
            model.addAttribute("docSchedule", newSchedule);
        }
        return "doctor-schedule";
    }

    @PostMapping("/doctor-schedule")
    public String saveDoctorSchedule(@ModelAttribute("docSchedule") DoctorSchedule doctorSchedule, BindingResult bindingResult) {
        doctorScheduleRepository.save(doctorSchedule);
        return "redirect:/doctor-schedule?doctorId=" + doctorSchedule.getDoctorId();
    }


}
