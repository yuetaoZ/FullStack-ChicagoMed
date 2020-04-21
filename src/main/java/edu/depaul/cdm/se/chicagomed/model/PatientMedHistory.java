package edu.depaul.cdm.se.chicagomed.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "patientMedHistory")
public class PatientMedHistory {
    private int patientId;
    private JsonNode medicalHistory;
}
