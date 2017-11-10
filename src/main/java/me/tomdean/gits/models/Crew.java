package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "crew", schema = "gits")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "crew_id", length = 5)
    private String crewId;
    private String supervisor;
}
