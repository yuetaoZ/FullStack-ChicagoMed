package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("LocationReview")
public class LocationReview {
    @Id
    public String locationId;
    public String locationReview;
    public String patientId;

    public LocationReview(String locationId, String review) {
        this.locationId = locationId;
        this.locationReview = review;
    }


    public String toString(){
        return "locationId:" + locationId + "Review :" + locationReview;
    }
}