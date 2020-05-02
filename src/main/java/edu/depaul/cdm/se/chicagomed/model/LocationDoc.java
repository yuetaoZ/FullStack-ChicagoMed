package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "locationdoc")
@ToString
public class LocationDoc {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doclocationid;

//    @OneToMany(
//            mappedBy = "locationId",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )

//    @ToString.Exclude
//    private List<Doctor> doctor_Id;

    @OneToMany(
            mappedBy = "locationId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column(name = "locationID")
    private String locationID;

    @OneToMany(
            mappedBy = "doctorId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column(name = "doctorID")
    private String doctorID;
}
