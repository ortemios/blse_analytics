package com.itmo.blse.repository;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    List<Game> getAllByMatchIn(Iterable<Match> matches);

    void deleteByPublicId(UUID id);
}
