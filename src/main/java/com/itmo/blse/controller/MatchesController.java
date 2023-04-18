package com.itmo.blse.controller;

import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.GameMapper;
import com.itmo.blse.mapper.MatchMapper;
import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import com.itmo.blse.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/matches", produces = "application/json")
public class MatchesController {

    @Autowired
    GameService gameService;

    @Autowired
    MatchMapper mapper;

    @PostMapping("/{id}/play-game/")
    public ResponseEntity<?> playGame(@PathVariable Long id, @RequestParam Long winnerId) {
        try {
            Match match = gameService.playGame(id, winnerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMatchDto(match));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }

    @PostMapping("/{id}/drop")
    public ResponseEntity<?> drop(@PathVariable Long id) {
        try {
            Match match = gameService.dropMatch(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMatchDto(match));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}


