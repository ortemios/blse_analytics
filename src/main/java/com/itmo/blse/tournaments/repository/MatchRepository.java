package com.itmo.blse.tournaments.repository;

import com.itmo.blse.tournaments.model.Match;
import com.itmo.blse.tournaments.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getMatchById(Long id);

    List<Match> getAllByNextMatch(Match match);

    List<Match> getAllByTournament(Tournament tournament);
}
