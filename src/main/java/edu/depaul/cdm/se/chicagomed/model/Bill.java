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
    @Column(name = "billid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billId;

    @Column(name = "billamt")
    private double billAmount;

    @Column(name = "paidamt")
    private double paidAmount;

    @Column(name = "duedate")
    private Date dueDate;

    @Column(name = "billbalance")
    private double billBalance;


    @ManyToOne
    @JoinColumn(name = "patientid", nullable = false)
    @ToString.Exclude
    private Patient patient;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "appointmentid", nullable = false)
    @ToString.Exclude
    private Appointment appointment;
}
