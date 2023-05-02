package com.itmo.blse.controller;

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
@RequestMapping(value = "/api/win-rate", produces = "application/json")
public class WinRateController {

    @Autowired
    StatsService statsService;

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam Long teamId) {
        try {
            Team team = teamService.getById(teamId);
            double gameWinRatio = statsService.getGameWinRate(team);
            double matchWinRatio = statsService.getMatchWinRate(team);
            return ResponseEntity.ok(
                    WinRatioDto.builder()
                            .gameWinRatio(gameWinRatio)
                            .matchWinRatio(matchWinRatio)
                            .build()
            );
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}
