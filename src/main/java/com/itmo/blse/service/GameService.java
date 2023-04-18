package com.itmo.blse.service;

import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.model.*;
import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.repository.GameVoteRepository;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

enum MatchStatus {
    FINISHED, IN_PROGRESS, VOTING
}

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameVoteRepository gameVoteRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    UserService userService;

    @Autowired
    TeamRepository teamRepository;

//    private GameStatus getWinner(Match match) {
//        Tournament tournament = match.getTournament();
//        List<Game> games = gameRepository.getGamesByMatch(match);
//
//        for (Game game : games) {
//            if (get)
//        }
//        if (games.size() == tournament.getMaxGames() && games.stream().allMatch(game -> getGameStatus(game) == GameStatus.APPROVED)) {
//            int team1Vicotries = games.stream().filter(game -> game.getWinner() == )
//        }
//    }

    private MatchStatus updateAndGetMatchStatus(Match match) {
        Tournament tournament = match.getTournament();

        List<Game> games = gameRepository.getGamesByMatch(match);
        int gamesApproved = 0;
        int team1Wins = 0, team2Wins = 0;
        for (Game game : games) {
            List<GameVote> gameVotes = gameVoteRepository.getGameVotesByGame(game);
            int total = gameVotes.size();
            int positive = (int) gameVotes.stream().filter(GameVote::isApproved).count();
            if (total == tournament.getJudges().size()) {
                if ((double) positive / total >= tournament.getApprovalRatio()) {
                    gamesApproved++;
                    if (game.getWinner() == match.getTeam1()) {
                        team1Wins++;
                    } else if (game.getWinner() == match.getTeam2()) {
                        team2Wins++;
                    } else {
                        assert false;
                    }
                } else {
                    gameRepository.delete(game);
                }
            } else {
                return MatchStatus.VOTING;
            }
        }
        if (gamesApproved == games.size() && games.size() == tournament.getMaxGames()) {
            Match next = match.getNextMatch();
            if (next != null) {
                Team winner = team1Wins > team2Wins ? match.getTeam1() : match.getTeam2();
                if (next.getTeam1() != winner && next.getTeam2() != winner) {
                    if (next.getTeam1() == null) {
                        next.setTeam1(winner);
                    } else if (next.getTeam2() == null) {
                        next.setTeam2(winner);
                    } else {
                        assert false;
                    }
                }
            }
            return MatchStatus.FINISHED;
        } else {
            return MatchStatus.IN_PROGRESS;
        }
    }

    public Match dropMatch(Long id) throws ValidationError {
        Match match = matchRepository.getMatchById(id);
        if (match == null) {
            throw new ValidationError(List.of("Match not found"));
        }
        Match next = match.getNextMatch();
        gameRepository.deleteByMatch(match);
        while (next != null) {
            next.setTeam2(null);
            next.setTeam1(null);
            gameRepository.deleteByMatch(next);
            next = next.getNextMatch();
        }
        return match;
    }

    public Match playGame(Long id, Long winnerId) throws ValidationError {
        Match match = matchRepository.getMatchById(id);
        Team winner = teamRepository.getTeamById(winnerId);

        if (match == null) {
            throw new ValidationError(List.of("Match not found"));
        }
        if (winner == null) {
            throw new ValidationError(List.of("Winner not found"));
        }
        if (match.getTeam1() != winner && match.getTeam2() != winner) {
            throw new ValidationError(List.of("Winner does not belong to match"));
        }
        if (updateAndGetMatchStatus(match) != MatchStatus.IN_PROGRESS) {
            throw new ValidationError(List.of("Can't play while the last game is not approved"));
        }

        Game game = new Game();
        game.setWinner(winner);
        game.setMatch(match);
        gameRepository.save(game);

        return match;
    }

    public Game approveGame(Long id, boolean isApproved) throws ValidationError {
        User user = userService.fromContext();

        Game game = gameRepository.getGameById(id);
        if (game == null) {
            throw new ValidationError(List.of("Game not found"));
        }
        Tournament tournament = game.getMatch().getTournament();
        if (!tournament.getJudges().contains(user)) {
            throw new ValidationError(List.of("User is not a judge"));
        }

        GameVote gameVote = new GameVote();
        gameVote.setGame(game);
        gameVote.setApproved(isApproved);
        gameVote.setJudge(user);
        gameVoteRepository.save(gameVote);

        updateAndGetMatchStatus(game.getMatch());

        return game;
    }
}
