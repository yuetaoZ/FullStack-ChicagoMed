package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("DoctorReview")
public class DoctorReview {
    @Id
    public String DoctorId;
    public String DoctorReview;
    public String patientId;

    public DoctorReview(String doctorId, String doctorReview) {
        DoctorId = doctorId;
        DoctorReview = doctorReview;
    }


    public String toString(){
        return "DoctorId:" + DoctorId + "Doctor Review :" + DoctorReview;
    }
}