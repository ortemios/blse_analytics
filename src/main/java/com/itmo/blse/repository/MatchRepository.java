package com.itmo.blse.repository;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<Match, UUID> {

    Match getMatchByPublicId(UUID publicId);

    List<Match> getAllByTeam1OrTeam2(Team team1, Team team2);
}
