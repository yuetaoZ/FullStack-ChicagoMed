package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.DoctorContact;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DoctorContactRepository extends CrudRepository<DoctorContact, Long> {
    List<DoctorContact> findByDoctor(Doctor doc);
}
