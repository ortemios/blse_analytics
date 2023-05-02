package com.itmo.blse.service;

import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> listTeams(){
        return teamRepository.findAll();
    }

    public Team getById(Long id) throws ValidationError {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isEmpty()) {
            throw new ValidationError(List.of(String.format("Team with id %s not found", id)));
        }
        return team.get();
    }


}
