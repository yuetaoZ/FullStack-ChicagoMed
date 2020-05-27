package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "DoctorSchedule")
public class DoctorSchedule {
    @Id
    private long doctorId;
    private Map<String, DaySchedule> schedule = new HashMap<>();
}
