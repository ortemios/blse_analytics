package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name="analytics_tournament")
@Getter
@Setter
@NoArgsConstructor
public class Tournament {

    @Id
    private UUID id;
    @Column
    String name;
    @Column
    Date startedAt;
    @OneToMany
    List<Team> teams;
    @OneToMany
    List<Match> matches;
}
