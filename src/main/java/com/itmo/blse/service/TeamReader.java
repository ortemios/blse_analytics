package com.itmo.blse.service;


import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.TournamentRepository;
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
