package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "patient")
@ToString
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column(unique = true)
    @Size(max = 5)
    private String patientId;

    @Column(name = "patientfirstname")
    private String patientFirstName;

    @Column(name = "patientlastname")
    private String patientLastName;

}
