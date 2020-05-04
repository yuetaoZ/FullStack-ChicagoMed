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
    @Column(name = "doclocationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doclocationId;

    @Column(name = "doctorid")
    private long doctorid;

    @Column(name = "locationid")
    private long locationId;

    @OneToMany(
            mappedBy = "locationid",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Location> locations;

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(name = "doctorid", nullable = false)
//    @ToString.Exclude
//    private Doctor doctor;
}
