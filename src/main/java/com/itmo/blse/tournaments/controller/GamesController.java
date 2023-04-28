package com.itmo.blse.tournaments.controller;

import com.itmo.blse.app.error.ValidationError;
import com.itmo.blse.tournaments.mapper.GameMapper;
import com.itmo.blse.tournaments.model.*;
import com.itmo.blse.tournaments.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/judge/games", produces = "application/json")
public class GamesController {

    @Autowired
    GameService gameService;

    @Autowired
    GameMapper gameMapper;

    @PostMapping("/{id}/approve/")
    public ResponseEntity<?> approve(@PathVariable Long id) {
        try {
            Game game = gameService.approveGame(id, true);
            return ResponseEntity.status(HttpStatus.CREATED).body(gameMapper.toGameDto(game));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }

    @PostMapping("/{id}/disapprove/")
    public ResponseEntity<?> disapprove(@PathVariable Long id){
        try {
            Game game = gameService.approveGame(id, false);
            return ResponseEntity.status(HttpStatus.CREATED).body(gameMapper.toGameDto(game));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}


