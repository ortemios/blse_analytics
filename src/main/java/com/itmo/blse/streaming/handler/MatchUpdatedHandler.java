package com.itmo.blse.streaming.handler;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.streaming.event.MatchUpdatedEvent;
import com.itmo.blse.streaming.model.MatchUpdatedModel;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchUpdatedHandler implements EventHandler<MatchUpdatedEvent> {

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void handle(MatchUpdatedEvent event) {
        MatchUpdatedModel data = event.getData();
        Team team1 = teamRepository.getTeamById(data.getTeam1PublicId());
        Team team2 = teamRepository.getTeamById(data.getTeam2PublicId());
        Team winner = teamRepository.getTeamById(data.getWinnerPublicId());
        Match match = matchRepository.getMatchById(data.getPublicId());
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setWinner(winner);
        matchRepository.save(match);
    }
}
