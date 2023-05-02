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

@RestController
@RequestMapping(value = "/api/tournaments", produces = "application/json")
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    StatsService statsService;

    @GetMapping("/{id}/stats/")
    public ResponseEntity<?> stats(@PathVariable Long id) {
        try {
            Tournament tournament = tournamentRepository.findById(id).orElseThrow(
                    () -> new ValidationError(List.of("Tournament " + id + " does not exist"))
            );

            return ResponseEntity.ok(
                    TournamentStatsDto.builder()
                            .id(id)
                            .teamIds(tournament.getTeams().stream().map(Team::getPublicId).toList())
                            .totalGames(statsService.getTournamentGamesTotal(tournament))
                            .totalMatches(tournament.getMatches().size())
                            .build()
            );
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}
