package com.itmo.blse.controller;

import com.itmo.blse.dto.CreateTournamentDto;
import com.itmo.blse.dto.ListTournamentDto;
import com.itmo.blse.dto.RetrieveTournamentDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.mapper.TournamentMapper;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.service.MatchService;
import com.itmo.blse.service.TournamentCreator;
import com.itmo.blse.service.TournamentReader;
import com.itmo.blse.validator.CreateTournamentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tournaments", produces = "application/json")
public class TournamentController {

    @Autowired
    TournamentReader tournamentReader;

    @Autowired
    CreateTournamentValidator createTournamentValidator;

    @Autowired
    TournamentCreator tournamentCreator;

    @Autowired
    TournamentMapper tournamentMapper;

    @GetMapping("/")
    public List<ListTournamentDto> getTournaments() {
        return tournamentReader
                .getAll()
                .stream()
                .map(ListTournamentDto::fromTournament)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/")
    public RetrieveTournamentDto getTournamentById(@PathVariable Long id) {
        Tournament tournament = tournamentReader.getById(id);
        if (tournament == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return tournamentMapper.toRetrieveTournamentDto(tournament);

    }


    @PostMapping("/")
    public ResponseEntity<?> createTournament(@RequestBody CreateTournamentDto createTournamentDto){
        try {
            createTournamentValidator.clean(createTournamentDto);
            Tournament tournament = tournamentCreator.create(createTournamentDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(tournamentMapper.toRetrieveTournamentDto(tournament));

        }
        catch (ValidationError err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}


