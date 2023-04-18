package com.itmo.blse.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game_vote")
public class GameVote extends Timestamped {

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "judge_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User judge;

    @Column(nullable = false)
    private boolean isApproved;

}
