package com.itmo.blse.repository;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getMatchById(Long id);
}
