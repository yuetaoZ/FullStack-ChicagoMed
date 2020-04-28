package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctorcontact")
@ToString
public class DoctorContact {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(
            mappedBy = "doctorId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Doctor> doctor_Id;

    @Column(name = "doctoremail")
    private String doctoremail;

    @Column(name = "doctorphonenumber")
    private String doctorphonenumber;

}
