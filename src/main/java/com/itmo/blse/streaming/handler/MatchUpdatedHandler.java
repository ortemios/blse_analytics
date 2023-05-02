package com.itmo.blse.streaming.handler;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.streaming.event.MatchUpdatedEvent;
import com.itmo.blse.streaming.model.MatchUpdatedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class MatchUpdatedHandler implements EventHandler<MatchUpdatedEvent> {

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void handle(MatchUpdatedEvent event) {
        MatchUpdatedModel data = event.getData();
        UUID team1Id = data.getTeam1PublicId();
        UUID team2Id = data.getTeam2PublicId();
        UUID winnerId = data.getWinnerPublicId();
        Team team1 = team1Id != null ? teamRepository.getTeamByPublicId(team1Id) : null;
        Team team2 = team2Id != null ? teamRepository.getTeamByPublicId(team2Id) : null;
        Team winner = winnerId != null ? teamRepository.getTeamByPublicId(winnerId) : null;
        Match match = matchRepository.getMatchByPublicId(data.getPublicId());
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setWinner(winner);
        matchRepository.save(match);
    }
}
