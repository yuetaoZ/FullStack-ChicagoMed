package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.DoctorSpecialization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, Long> {
    List<DoctorSpecialization> findByDoctor(Doctor doctor);
}
