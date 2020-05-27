package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.DoctorSchedule;
import org.springframework.data.repository.CrudRepository;

public interface DoctorScheduleRepository extends CrudRepository<DoctorSchedule, Long> {
}
