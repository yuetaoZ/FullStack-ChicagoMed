package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "patientdob")
@ToString
public class PatientDOB {

    private static final long serialVersionUID = 2L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @OneToMany(
            mappedBy = "patientId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Patient> patient_Id;

    @Column(name = "dateofbirth")
    private String patient_DOB;
}
