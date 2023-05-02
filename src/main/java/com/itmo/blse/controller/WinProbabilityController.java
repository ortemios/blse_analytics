package com.itmo.blse.controller;

import com.itmo.blse.dto.WinProbabilityDto;
import com.itmo.blse.dto.WinRatioDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/winProbability", produces = "application/json")
public class WinProbabilityController {

    @Autowired
    StatsService statsService;

    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam UUID team1Id, @RequestParam UUID team2Id) {
        try {
            double probability = statsService.getWinProbability(team1Id, team2Id);
            return ResponseEntity.ok(WinProbabilityDto.builder().probability(probability));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}
