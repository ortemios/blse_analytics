package com.itmo.blse.tournaments.repository;

import com.itmo.blse.tournaments.model.Game;
import com.itmo.blse.tournaments.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game getGameById(Long id);

    List<Game> getGamesByMatch(Match match);

    @Transactional
    @Modifying
    void deleteAllByMatch(Match match);
}
