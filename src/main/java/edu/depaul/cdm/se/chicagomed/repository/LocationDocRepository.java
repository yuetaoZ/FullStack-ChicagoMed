package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Bill;
import edu.depaul.cdm.se.chicagomed.model.LocationDoc;
import org.springframework.data.repository.CrudRepository;

public interface LocationDocRepository extends CrudRepository<LocationDoc, String> {
}
