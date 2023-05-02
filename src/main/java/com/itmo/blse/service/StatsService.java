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

    public double getGameWinRate(Team team) {

        List<Match> matches = matchRepository.getAllByTeam1OrTeam2(team, team);
        List<Game> games = gameRepository.getAllByMatchIn(matches);
        if (games.size() == 0) {
            return 0;
        }
        long wins = games.stream().filter(game -> game.getWinner().getPublicId() == team.getPublicId()).count();
        return (double) wins / games.size();
    }

    public double getMatchWinRate(Team team) {

        List<Match> matches = matchRepository.getAllByTeam1OrTeam2(team, team);
        if (matches.size() == 0) {
            return 0;
        }
        long wins = matches.stream().filter(match -> match.getWinner().getPublicId() == team.getPublicId()).count();
        return (double) wins / matches.size();
    }

    public double getGameWinProbability(Team team1, Team team2) {
        double rate1 = getGameWinRate(team1);
        double rate2 = getGameWinRate(team2);
        return rate1 == 0 && rate2 == 0 ? 0 : rate1 / (rate1 + rate2);
    }

    public double getMatchWinProbability(Team team1, Team team2) {
        double rate1 = getMatchWinRate(team1);
        double rate2 = getMatchWinRate(team2);
        return rate1 == 0 && rate2 == 0 ? 0 : rate1 / (rate1 + rate2);
    }

    public Integer getTournamentGamesTotal(Tournament tournament) {
        List<Match> matches = tournament.getMatches();
        return gameRepository.getAllByMatchIn(matches).size();
    }
}
