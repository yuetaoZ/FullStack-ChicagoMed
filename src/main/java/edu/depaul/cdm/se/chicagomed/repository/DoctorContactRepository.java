package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.DoctorContact;
import org.springframework.data.repository.CrudRepository;

public interface DoctorContactRepository extends CrudRepository<DoctorContact, Long> {
//    Doctor findByDoctor(Doctor doc);
}
