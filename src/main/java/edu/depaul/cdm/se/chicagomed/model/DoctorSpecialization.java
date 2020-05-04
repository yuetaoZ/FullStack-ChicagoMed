package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "doctorspecialization")
@ToString
public class DoctorSpecialization {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "doctorid")
    private long doctorId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "doctorid", nullable = false)
    @ToString.Exclude
    private Doctor doctor;

    @Column(name = "specialization")
    private String doctor_Specialization;
}
