package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppoinmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(String AppDate);

    List<Appointment> findAllByDoctor(Doctor doctor);

   List<Appointment> findAllByPatient(Patient patient);


    @Override
    List<Appointment> findAll();

}
