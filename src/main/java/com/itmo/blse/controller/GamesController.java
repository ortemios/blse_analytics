package com.itmo.blse.controller;

import com.itmo.blse.dto.ListTournamentDto;
import com.itmo.blse.dto.RetrieveTournamentDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.GameMapper;
import com.itmo.blse.model.*;
import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.repository.GameVoteRepository;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.service.GameService;
import com.itmo.blse.service.TournamentCreator;
import com.itmo.blse.service.TournamentReader;
import com.itmo.blse.service.UserService;
import com.itmo.blse.validator.CreateTournamentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/games", produces = "application/json")
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


