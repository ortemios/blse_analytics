package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game getGameById(Long id);

    List<Game> getGamesByMatch(Match match);

    void deleteByMatch(Match match);
}
