package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;

@Data
public class DoctorInfo {
    private String doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorEmail;
    private String doctorPhone;
}
