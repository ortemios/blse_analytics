package com.itmo.blse.controller;

import com.itmo.blse.dto.ListTournamentDto;
import com.itmo.blse.dto.RetrieveTournamentDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.model.Game;
import com.itmo.blse.model.GameVote;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Tournament;
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
    GameRepository gameRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    GameService gameService;

    @PostMapping("/play/")
    public ResponseEntity<?> play(@RequestParam Map<String, Long> body) {
        return gameService.playMatch(body.get("game_id"), body.get("winner_id"));
    }

    @PostMapping("/approve/")
    public ResponseEntity<?> approve(@RequestParam Long id){
        return gameService.approveGame(id, true);
    }

    @PostMapping("/disapprove/")
    public ResponseEntity<?> disapprove(@RequestParam Long id){
        return gameService.approveGame(id, false);
    }
}


