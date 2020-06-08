package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "DoctorSchedule")
public class DoctorSchedule {
    @Id
    private long doctorId;
    private WeekSchedule schedule;
}
