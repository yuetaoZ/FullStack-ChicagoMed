package edu.depaul.cdm.se.chicagomed.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ApptNotes")
public class ApptNotes {
    @Id
    private int appointmentId;
    private JsonNode appointmentNotes;

}
