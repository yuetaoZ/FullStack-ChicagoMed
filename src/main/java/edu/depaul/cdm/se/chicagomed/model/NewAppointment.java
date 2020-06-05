package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;

@Data


public class NewAppointment {
    private String locationId;
    private String doctorId;
    private String apptDateTime;
    private String patientId;
}
