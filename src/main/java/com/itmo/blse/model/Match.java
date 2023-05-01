package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity(name="analytics_match")
@Setter
@NoArgsConstructor
public class Match {

    @Id
    private UUID id;

    @ManyToOne
    Team team1;

    @ManyToOne
    Team team2;

    @ManyToOne
    Team winner;
}
