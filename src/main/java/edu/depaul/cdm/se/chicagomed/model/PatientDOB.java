package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "patientdob")
@ToString
public class PatientDOB {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "patientid")
    private long patientId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "patientid", nullable = false)
    @ToString.Exclude
    private Patient patient;

    @Column(name = "dateofbirth")
    private Date patientDOB;
}
