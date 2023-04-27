package com.itmo.blse.controller;

import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.MatchMapper;
import com.itmo.blse.mapper.TournamentMapper;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/moderator/matches", produces = "application/json")
public class MatchesController {

    @Autowired
    GameService gameService;

    @Autowired
    MatchMapper matchMapper;

    @Autowired
    TournamentMapper tournamentMapper;

    @PostMapping("/{id}/play-game/")
    public ResponseEntity<?> playGame(@PathVariable Long id, @RequestParam Long winnerId) {
        try {
            Match match = gameService.playGame(id, winnerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(matchMapper.toMatchDto(match));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }

    @PostMapping("/{id}/drop/")
    public ResponseEntity<?> drop(@PathVariable Long id) {
        try {
            Tournament tournament = gameService.dropMatch(id);
            return ResponseEntity.status(HttpStatus.OK).body(tournamentMapper.toRetrieveTournamentDto(tournament));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}


