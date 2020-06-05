package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")
@ToString
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "patientid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @Column(name = "patientfirstname")
    private String patientFirstName;

    @Column(name = "patientlastname")
    private String patientLastName;

    @Column(name = "patientdob")
    private String patientDOB;

    @Column(name = "patientgender")
    private String patientGender;





}
