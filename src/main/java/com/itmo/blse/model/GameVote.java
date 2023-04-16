package com.itmo.blse.model;

import javax.persistence.*;

@Entity
@Table(name = "game_vote")
public class GameVote extends Timestamped{

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "judge_id", nullable = false)
    private User judge;

    @Column(nullable = false)
    private boolean isApproved;

}
