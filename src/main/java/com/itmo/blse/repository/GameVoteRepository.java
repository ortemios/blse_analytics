package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.GameVote;
import com.itmo.blse.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameVoteRepository extends JpaRepository<GameVote, Long> {

    GameVote getGameVoteById(Long id);

    List<GameVote> getGameVotesByGame(Game game);
}
