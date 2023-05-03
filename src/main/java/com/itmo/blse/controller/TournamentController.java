package com.itmo.blse.controller;


import com.itmo.blse.dto.TournamentStatsDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.TournamentRepository;
import com.itmo.blse.service.StatsService;
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
@RequestMapping(value = "/api/tournaments", produces = "application/json")
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    StatsService statsService;

    @GetMapping("/stats/")
    public ResponseEntity<?> stats() {
        List<TournamentStatsDto> tournaments = tournamentRepository.findAll()
                .stream().map(
                        t -> TournamentStatsDto.builder()
                                .id(t.getId())
                                .teamIds(t.getTeams().stream().map(Team::getId).toList())
                                .totalGames(statsService.getTournamentGamesTotal(t))
                                .totalMatches(t.getMatches().size())
                                .build()
                ).toList();

        return ResponseEntity.ok(tournaments);
    }
}
