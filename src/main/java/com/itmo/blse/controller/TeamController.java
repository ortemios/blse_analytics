package com.itmo.blse.controller;


import com.itmo.blse.dto.TeamDto;
import com.itmo.blse.dto.TournamentStatsDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.TournamentRepository;
import com.itmo.blse.service.StatsService;
import com.itmo.blse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/teams", produces = "application/json")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public List<TeamDto> getTeams() {
        return teamService.listTeams().stream().map(
                t -> new TeamDto(t.getId(), t.getName())
        ).collect(Collectors.toList());
    }
}
