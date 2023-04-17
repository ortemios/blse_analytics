package com.itmo.blse.model;

import javax.persistence.*;
import java.util.List;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game extends Timestamped{

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "game_vote",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "judge_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"game_id", "judge_id"}))
    private Set<User> judges;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Team winner;


}