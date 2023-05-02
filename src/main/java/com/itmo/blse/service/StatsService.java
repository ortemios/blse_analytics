package com.itmo.blse.service;

import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StatsService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    TournamentRepository tournamentRepository;

    public double getWinRate(UUID teamId) throws ValidationError {
        if (!teamRepository.existsById(teamId)) {
            throw new ValidationError(List.of("Team " + teamId + " does not exist"));
        }
        Team team = teamRepository.getTeamByPublicId(teamId);
        List<Match> matches = matchRepository.getAllByTeam1OrTeam2(team, team);
        List<Game> games = gameRepository.getAllByMatchIn(matches);
        if (games.size() == 0) {
            return 0;
        }
        long wins = games.stream().filter(game -> game.getWinner().getPublicId() == teamId).count();
        return (double) wins / games.size();
    }

    public double getWinProbability(UUID teamId1, UUID teamId2) throws ValidationError {
        double rate1 = getWinRate(teamId1);
        double rate2 = getWinRate(teamId2);
        return rate1 / (rate1 + rate2);
    }

    public Integer getTournamentGamesTotal(UUID tournamentId) {
        Tournament tournament = tournamentRepository.findTournamentByPublicId(tournamentId);
        List<Match> matches = tournament.getMatches();
        return gameRepository.getAllByMatchIn(matches).size();
    }
}
