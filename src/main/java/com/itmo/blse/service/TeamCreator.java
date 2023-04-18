package com.itmo.blse.service;


import com.itmo.blse.model.Team;
import com.itmo.blse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
