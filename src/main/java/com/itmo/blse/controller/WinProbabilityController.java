package com.itmo.blse.controller;

import com.itmo.blse.dto.WinProbabilityDto;
import com.itmo.blse.dto.WinRatioDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Team;
import com.itmo.blse.service.StatsService;
import com.itmo.blse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/win-probability", produces = "application/json")
public class WinProbabilityController {

    @Autowired
    StatsService statsService;

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam Long team1Id, @RequestParam Long team2Id) {
        try {
            Team team1 = teamService.getById(team1Id);
            Team team2 = teamService.getById(team2Id);
            double gameProbability = statsService.getGameWinProbability(team1, team2);
            double matchProbability = statsService.getMatchWinProbability(team1, team2);
            return ResponseEntity.ok(
                    WinProbabilityDto.builder()
                            .gameProbability(gameProbability)
                            .matchProbability(matchProbability)
                            .build()
            );
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}
