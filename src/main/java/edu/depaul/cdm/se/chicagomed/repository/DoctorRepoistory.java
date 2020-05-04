package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepoistory extends CrudRepository<Doctor, Long> {
}
