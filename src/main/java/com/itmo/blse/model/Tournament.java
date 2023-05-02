package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity(name="analytics_tournament")
@Getter
@Setter
@NoArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    UUID publicId;

    @Column
    String name;

    @OneToMany
    List<Team> teams;

    @OneToMany
    List<Match> matches;
}
