package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Appointment;
import edu.depaul.cdm.se.chicagomed.model.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, String> {
//    @Override
//    List<Bill> findall();
//
}
