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
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentId;

//    @ManyToOne
//    @Column(unique = true)
//    @Size(max = 5)
//    private String appointmentId;

    @Column(name = "appointmentdate")
    private String appointmentDate;

    @OneToMany(
            mappedBy = "patientId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Patient> patient_Id;

//    @OneToMany(
//            mappedBy = "doctorId",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
    @ToString.Exclude
    private Doctor doctor_Id;

    @OneToMany(
            mappedBy = "locationId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Location> location_Id;
}
