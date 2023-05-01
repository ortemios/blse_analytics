package com.itmo.blse.repository;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<Match, UUID> {

    Match getMatchById(UUID id);
}
