package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findByDoctorId(String doctorId);
}
