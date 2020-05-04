package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppoinmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(String AppDate);

    @Override
    List<Appointment> findAll();
}
