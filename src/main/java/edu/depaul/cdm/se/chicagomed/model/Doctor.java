package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

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
    @Column(name = "doctorid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private long doctorId;

    @Column(name = "doctorfirstname")
    private String doctorFirstName;

    @Column(name = "doctorlastname")
    private String doctorLastName;

}
