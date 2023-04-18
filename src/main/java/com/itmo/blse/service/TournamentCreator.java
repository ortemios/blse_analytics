package com.itmo.blse.service;


import com.itmo.blse.dto.CreateTournamentDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentCreator {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    MatchesTreeBuilder matchesTreeBuilder;



    public Tournament create(CreateTournamentDto data) throws ValidationError {
        Tournament tournament = Tournament
                .builder()
                .name(data.getName())
                .maxGames(data.getMaxGames())
                .approvalRatio(data.getApprovalRatio())
                .startDate(data.getStartDate())
                .judges(data.getJudges())
                .teams(data.getTeams())
                .build();

        tournamentRepository.save(tournament);
        matchesTreeBuilder.buildMatchesTree(tournament);


        return tournamentRepository.getTournamentById(tournament.getId());  // refresh from db


    }
}
