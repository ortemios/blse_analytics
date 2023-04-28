package com.itmo.blse.tournaments.repository;

import com.itmo.blse.tournaments.model.Game;
import com.itmo.blse.tournaments.model.GameVote;
import com.itmo.blse.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface GameVoteRepository extends JpaRepository<GameVote, Long> {

    List<GameVote> getGameVotesByGame(Game game);

    @Transactional
    @Modifying
    void deleteAllByGameAndJudge(Game game, User user);
}
