package edu.depaul.cdm.se.chicagomed.controller;

import edu.depaul.cdm.se.chicagomed.model.*;
import edu.depaul.cdm.se.chicagomed.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private DoctorContactRepository doctorContactRepository;



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


    @GetMapping("/admin-new-patient")
    public String setNewPatientInfo(@RequestParam(name = "adminId", required = false, defaultValue = "none") String adminId, Model model) {
        Optional<Admin> admin = adminRepository.findById(Long.parseLong(adminId));
        if (admin.isPresent()) {
            PatientInfo patientInfo = new PatientInfo();
            model.addAttribute("admin", admin.get());
            model.addAttribute("patientInfo", patientInfo);

            return "admin-new-patient";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Admin not found");

    }


    @PostMapping(path="/admin-new-patientInfo-save")
    public String saveNewPatient(@RequestParam(name = "adminId", required = false, defaultValue = "none") String adminId, @ModelAttribute("patientInfo") PatientInfo patientInfo) {
        Optional<Admin> admin = adminRepository.findById(Long.parseLong(adminId));
        if (admin.isPresent()) {

            savePatientInfo(patientInfo);

            return "redirect:/admin-patients?adminId=" + adminId;
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Admin not found");
    }

    private void savePatientInfo(PatientInfo patientInfo) {
        Patient patient = new Patient();
        patient.setPatientId(patient.getPatientId());
        patient.setPatientFirstName(patientInfo.getPatientFirstName());
        patient.setPatientLastName(patientInfo.getPatientLastName());
        patient.setPatientDOB(patientInfo.getPatientDOB());
        patient.setPatientGender(patientInfo.getPatientGender());
        patientRepository.save(patient);

        PatientContact patientContact = new PatientContact();
        patientContact.setPatientId(patient.getPatientId());
        patientContact.setAddress(patientInfo.getAddress());
        patientContact.setCity(patientInfo.getCity());
        patientContact.setEmail(patientInfo.getEmail());
        patientContact.setPhonenumber(patientInfo.getPhonenumber());
        patientContact.setState(patientInfo.getState());
        patientContact.setZipcode(patientInfo.getZipcode());
        patientContactRepository.save(patientContact);
    }


    @GetMapping("/admin-new-doctor")
    public String setNewDoctorInfo(@RequestParam(name = "adminId", required = false, defaultValue = "none") String adminId, Model model) {
        Optional<Admin> admin = adminRepository.findById(Long.parseLong(adminId));
        if (admin.isPresent()) {
            DoctorInfo doctorInfo = new DoctorInfo();
            model.addAttribute("admin", admin.get());
            model.addAttribute("doctorInfo", doctorInfo);

            return "admin-new-doctor";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Admin not found");

    }


    @PostMapping(path="/admin-new-doctorInfo-save")
    public String saveNewPatient(@RequestParam(name = "adminId", required = false, defaultValue = "none") String adminId, @ModelAttribute("doctorInfo") DoctorInfo doctorInfo) {
        Optional<Admin> admin = adminRepository.findById(Long.parseLong(adminId));
        if (admin.isPresent()) {

            saveDoctorInfo(doctorInfo);

            return "redirect:/admin-patients?adminId=" + adminId;
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Admin not found");
    }

    private void saveDoctorInfo(DoctorInfo doctorInfo) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctor.getDoctorId());
        doctor.setDoctorFirstName(doctorInfo.getDoctorFirstName());
        doctor.setDoctorLastName(doctorInfo.getDoctorLastName());
        doctorRepository.save(doctor);

        DoctorContact doctorContact = new DoctorContact();
        doctorContact.setDoctorId(doctor.getDoctorId());
        doctorContact.setDoctoremail(doctorInfo.getDoctorEmail());
        doctorContact.setDoctorphonenumber(doctorInfo.getDoctorPhone());
        doctorContactRepository.save(doctorContact);
    }


    @GetMapping("/admin-patientInfo-edit")
    public String getPatientInfoEdit(@RequestParam(name = "patientId", required = false, defaultValue = "none") String patientId, Model model) {
        Optional<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
        Optional<PatientContact> patientContact = patientContactRepository.findById(Long.parseLong(patientId));
        PatientInfo updatedPatientInfo = new PatientInfo();
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            model.addAttribute("patientContact", patientContact.get());
            model.addAttribute("updatedPatientInfo", updatedPatientInfo);

            return "admin-patientInfo-edit";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Patient not found");
    }


    @PostMapping(path="/admin-patientInfo-update")
    public String updatePatientInfo(@RequestParam(value="saveButton") Long patientId, @ModelAttribute("updatedPatient") PatientInfo updatedPatientInfo) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new IllegalArgumentException("Invalid Patient ID:" + patientId)
        );
        PatientContact patientContact = patientContactRepository.findById(patientId).orElseThrow(
                () -> new IllegalArgumentException("Invalid Patient ID:" + patientId)
        );

        patient.setPatientFirstName(updatedPatientInfo.getPatientFirstName());
        patient.setPatientLastName(updatedPatientInfo.getPatientLastName());
        patient.setPatientDOB(updatedPatientInfo.getPatientDOB());
        patient.setPatientGender(updatedPatientInfo.getPatientGender());

        patientContact.setAddress(updatedPatientInfo.getAddress());
        patientContact.setCity(updatedPatientInfo.getCity());
        patientContact.setEmail(updatedPatientInfo.getEmail());
        patientContact.setPhonenumber(updatedPatientInfo.getPhonenumber());
        patientContact.setState(updatedPatientInfo.getState());
        patientContact.setZipcode(updatedPatientInfo.getZipcode());

        patientRepository.save(patient);
        patientContactRepository.save(patientContact);

        return "redirect:/admin-patientInfo?patientId=" + patient.getPatientId();
    }


    @GetMapping("/admin-patient-appointments-history")
    public String getPatientAppointmentsHistory(@RequestParam (name = "patientId", required = false, defaultValue = "none")  String patientId , Model model) {

        Optional<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
     //   Optional<Appointment> appointments = appointmentRepository.findById();
     //   Optional<Appointment>appointments = appointmentRepository.findById(patient.get().getPatientId());
        if (patient.isPresent()) {

            Iterable<Appointment> appts = appointmentRepository.findAllByPatient(patient.get());

            model.addAttribute("patient", patient.get());
       //     model.addAttribute("appointments",appointments.get());
            model.addAttribute("appointment",appts);

            return "admin-patient-appointments-history";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appointment not found");
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


    @GetMapping(path="/admin-cancel-appointment", params = "delete")
    public String delete(@RequestParam Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Appointment ID:" + id)
        );
        appointmentRepository.delete(appointment);
        return "redirect:/admin-patient-upcoming-appointments?patientId=" + appointment.getPatient().getPatientId();
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
    public String getPatientAppointmentDetails(@RequestParam (name = "appointmentId", required = false, defaultValue = "none")  String appointmentId , Model model) {

        Optional<Appointment> appointment = appointmentRepository.findById(Long.parseLong(appointmentId));
        Optional<Patient> patient = patientRepository.findById(appointment.get().getPatient().getPatientId());
        Optional<Doctor> doctor = doctorRepository.findById(appointment.get().getDoctor().getDoctorId());
        if (appointment.isPresent()) {
            model.addAttribute("getpatient", patient.get());
            model.addAttribute("doctor", doctor.get());

            model.addAttribute("appointment", appointment.get());

            return "admin-patient-appointment-details";
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appointment not found");
    }





    @GetMapping("/admin-patient-billing-info")
    public String getPatientBillingInfo(@RequestParam(name = "appointmentId", required = false, defaultValue = "none") String appointmentId, Model model) {

        Optional<Appointment> appointment = appointmentRepository.findById(Long.parseLong(appointmentId));
        Optional<Patient> patient = patientRepository.findById(appointment.get().getPatient().getPatientId());
        Optional<Bill> bill = billRepository.findById(appointment.get().getAppointmentId());
        if (appointment.isPresent()) {


            model.addAttribute("getpatient", patient.get());
            model.addAttribute("appointment", appointment.get());
            model.addAttribute("billing",bill.get());


            return "admin-patient-billing-info";
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Appointment not found");
    }

}
