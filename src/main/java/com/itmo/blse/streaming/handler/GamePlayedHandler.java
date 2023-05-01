package com.itmo.blse.streaming.handler;

import com.itmo.blse.model.Game;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.repository.MatchRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.streaming.event.GamePlayedEvent;
import com.itmo.blse.streaming.model.GamePlayedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class GamePlayedHandler implements EventHandler<GamePlayedEvent> {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void handle(GamePlayedEvent event) {
        GamePlayedModel model = event.getData();
        UUID matchId = model.getMatchPublicId();
        UUID winnerId = model.getWinnerPublicId();
        Match match = matchId != null ? matchRepository.getMatchById(model.getMatchPublicId()) : null;
        Team winner = winnerId != null ? teamRepository.getTeamById(model.getWinnerPublicId()) : null;
        Game game = new Game();
        game.setId(event.getData().getPublicId());
        game.setMatch(match);
        game.setWinner(winner);
        gameRepository.save(game);
    }
}
