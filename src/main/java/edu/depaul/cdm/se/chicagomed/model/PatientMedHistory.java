package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "PatientMedHistory")
public class PatientMedHistory {
    @Id
    private long patientId;
    private String medicalHistory;
}
