package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Location;
import edu.depaul.cdm.se.chicagomed.model.LocationDoc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationDocRepository extends CrudRepository<LocationDoc, Long> {
    List<LocationDoc> findByLocation(Location loc);
}
