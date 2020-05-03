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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentid;

    @Column(name = "appointmentdate")
    private String appointmentDate;

    @OneToOne(
            mappedBy = "patientId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private Patient patient_Id;

    @OneToOne(
            mappedBy = "doctorId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private Doctor doctor_Id;

    @OneToOne(
            mappedBy = "locationId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private Location location_Id;

}
