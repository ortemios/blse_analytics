package com.itmo.blse.tournaments.service;


import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.tournaments.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamReader {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public Team getById(Long id){
        return teamRepository.getTeamById(id);
    }
}
