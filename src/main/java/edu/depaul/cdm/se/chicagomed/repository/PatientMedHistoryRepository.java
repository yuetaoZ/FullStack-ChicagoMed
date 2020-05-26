package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.PatientMedHistory;
import org.springframework.data.repository.CrudRepository;

public interface PatientMedHistoryRepository extends CrudRepository<PatientMedHistory, Long> {
}
