package com.itmo.blse.controller;

import com.itmo.blse.dto.*;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.TeamMapper;
import com.itmo.blse.mapper.TournamentMapper;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.service.TeamCreator;
import com.itmo.blse.service.TeamReader;
import com.itmo.blse.service.TournamentCreator;
import com.itmo.blse.service.TournamentReader;
import com.itmo.blse.validator.CreateTeamValidator;
import com.itmo.blse.validator.CreateTournamentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/", produces = "application/json")
public class TeamController {

    @Autowired
    TeamCreator teamCreator;

    @Autowired
    CreateTeamValidator createTeamValidator;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    TeamReader teamReader;

    @GetMapping("user/teams/")
    public List<TeamDto> getTeams() {
        return teamReader.getAll().stream().map(teamMapper::toTeamDto).collect(Collectors.toList());
    }

    @GetMapping("user/teams/{id}/")
    public TeamDto getTeamById(@PathVariable Long id) {
        Team team = teamReader.getById(id);
        if (team == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return teamMapper.toTeamDto(team);

    }


    @PostMapping("moderator/teams/")
    public ResponseEntity<?> createTeam(@NonNull @RequestParam String name){
        try {
            createTeamValidator.clean(name);
            Team team = teamCreator.create(name);
            return ResponseEntity.status(HttpStatus.CREATED).body(teamMapper.toTeamDto(team));

        }
        catch (ValidationError err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}


