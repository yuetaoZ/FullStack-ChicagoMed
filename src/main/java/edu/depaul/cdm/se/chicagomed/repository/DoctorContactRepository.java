package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Bill;
import edu.depaul.cdm.se.chicagomed.model.DoctorContact;
import org.springframework.data.repository.CrudRepository;

public interface DoctorContactRepository extends CrudRepository<DoctorContact, String> {
}