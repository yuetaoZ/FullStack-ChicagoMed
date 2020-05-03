package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "bill")
@ToString
public class Bill {

    private static final long serialVersionUID = 11L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billid;

//    @ManyToOne
//    @Column(unique = true)
//    @Size(max = 5)
//    private String billId;

    @Column(name = "billamt")
    private double billAmount;

    @Column(name = "paidamt")
    private double paidAmount;

    @Column(name = "duedate")
    private Date dueDate;

    @Column(name = "billbalance")
    private double billBalance;


    @OneToMany(
            mappedBy = "patientId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Patient> patient_Id;

    @OneToMany(
            mappedBy = "appointmentId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Appointment> appointment_ID;
}
