package com.itmo.blse.service;


import com.itmo.blse.model.Match;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public List<Match> getTournamentMatches(Tournament tournament){
        return matchRepository.getAllByTournament(tournament);
    }
}
