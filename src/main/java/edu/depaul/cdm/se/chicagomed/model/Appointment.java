package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "appointment")
@ToString
public class Appointment {

    private static final long serialVersionUID = 10L;

    @Id
    @Column(name = "appointmentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentId;

    @Column(name = "appointmentdatetime")
    private String appointmentDate;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "patientid", nullable = false)
    @ToString.Exclude
    private Patient patient;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "doctorid", nullable = false)
    @ToString.Exclude
    private Doctor doctor;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "locationid", nullable = false)
    @ToString.Exclude
    private Location location;


}
