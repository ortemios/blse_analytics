package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.GameVote;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface GameVoteRepository extends JpaRepository<GameVote, Long> {

    GameVote getGameVoteById(Long id);

    List<GameVote> getGameVotesByGame(Game game);

    @Transactional
    @Modifying
    void deleteAllByGameAndJudge(Game game, User user);
}
