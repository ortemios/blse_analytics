package com.itmo.blse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Match {
    UUID id;
    Team team1, team2, winner;
}
