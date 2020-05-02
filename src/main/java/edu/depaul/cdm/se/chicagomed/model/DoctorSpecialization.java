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

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @OneToMany(
            mappedBy = "doctorId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Doctor> doctor_ID;

    @Column(name = "specialization")
    private String doctor_Specialization;
}
