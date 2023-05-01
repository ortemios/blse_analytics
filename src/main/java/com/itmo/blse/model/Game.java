package com.itmo.blse.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="analytics_game")
@Getter
@Setter
@NoArgsConstructor
public class Game {
    @Id
    UUID id;
    @ManyToOne
    Match match;
    @ManyToOne
    Team winner;
}
