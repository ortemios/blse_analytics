package com.itmo.blse.tournaments.service;


import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.tournaments.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamCreator {

    @Autowired
    TeamRepository teamRepository;

    public Team create(String name) {
        Team team = Team.builder().name(name).build();
        teamRepository.save(team);
        return team;
    }
}
