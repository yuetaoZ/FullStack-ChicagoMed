package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppoinmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(String AppDate);

    List<Appointment> findAllByDoctor(Doctor doctor);

    @Override
    List<Appointment> findAll();
}
