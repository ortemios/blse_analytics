package com.itmo.blse.tournaments.repository;

import com.itmo.blse.tournaments.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getTeamById(Long id);
    List<Team> getAllByIdIn(List<Long> ids);
    Team getTeamByName(String name);
}
