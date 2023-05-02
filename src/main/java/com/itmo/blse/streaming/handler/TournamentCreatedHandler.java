package com.itmo.blse.streaming.handler;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.TournamentRepository;
import com.itmo.blse.streaming.event.TournamentCreatedEvent;
import com.itmo.blse.streaming.model.MatchCreatedModel;
import com.itmo.blse.streaming.model.TournamentCreatedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class TournamentCreatedHandler implements EventHandler<TournamentCreatedEvent> {

    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchRepository matchRepository;

    @Override
    public void handle(TournamentCreatedEvent event) {
        List<Match> matches = new ArrayList<>();
        for (MatchCreatedModel model : event.getData().getMatches()) {
            UUID team1Id = model.getTeam1PublicId();
            UUID team2Id = model.getTeam2PublicId();
            Team team1 = team1Id != null ? teamRepository.getTeamByPublicId(team1Id) : null;
            Team team2 = team2Id != null ? teamRepository.getTeamByPublicId(team2Id) : null;
            Match match = new Match();
            match.setPublicId(model.getPublicId());
            match.setTeam1(team1);
            match.setTeam2(team2);
            matches.add(matchRepository.save(match));
        }
        TournamentCreatedModel data = event.getData();
        Tournament tournament = new Tournament();
        tournament.setPublicId(data.getPublicId());
        tournament.setName(data.getName());
        tournament.setMatches(matches);
        tournament.setTeams(teamRepository.findAllByPublicIdIn(data.getTeams()));
        Tournament res = tournamentRepository.save(tournament);
        System.out.println(res.toString());
    }
}
