package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "admin")
@ToString
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "adminid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;

    @Column(name = "adminname")
    private String adminName;

}
