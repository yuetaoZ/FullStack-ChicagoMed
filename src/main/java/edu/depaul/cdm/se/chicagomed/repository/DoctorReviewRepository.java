package edu.depaul.cdm.se.chicagomed.repository;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.model.DoctorReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface DoctorReviewRepository extends MongoRepository<DoctorReview, String>{
    List<DoctorReview> findDoctorReviewByDoctorId (Doctor doc);

    @Override
    List<DoctorReview> findAll();
}