package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;

@Data
public class PatientInfo {
    private String patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientDOB;
    private String patientGender;
    private String email;
    private String phonenumber;
    private String address;
    private String city;
    private String state;
    private long zipcode;
}
