package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Bill;
import edu.depaul.cdm.se.chicagomed.model.DoctorSpecialization;
import org.springframework.data.repository.CrudRepository;

public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, String> {
}
