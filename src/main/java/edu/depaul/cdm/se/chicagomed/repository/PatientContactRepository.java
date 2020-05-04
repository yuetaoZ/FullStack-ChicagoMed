package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.PatientContact;
import org.springframework.data.repository.CrudRepository;

public interface PatientContactRepository extends CrudRepository<PatientContact, Long> {
}
