package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctorcontact")
@ToString
public class DoctorContact {
    private static final long serialVersionUID = 3L;

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

    @Column(name = "doctoremail")
    private String doctoremail;

    @Column(name = "doctorphonenumber")
    private String doctorphonenumber;

}
