package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "doctor")
@ToString
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorid;

//    @ManyToOne
//    @Column(unique = true)
//    @Size(max = 5)
//    private String doctorId;

    @Column(name = "doctorfirstname")
    private String doctorFirstName;

    @Column(name = "doctorlastname")
    private String doctorLastName;

}
