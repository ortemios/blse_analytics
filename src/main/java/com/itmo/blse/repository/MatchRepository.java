package com.itmo.blse.repository;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getMatchByPublicId(UUID publicId);

    List<Match> getAllByTeam1OrTeam2(Team team1, Team team2);

    List<Match> getAllByTeam1AndTeam2(Team team1, Team team2);
}
