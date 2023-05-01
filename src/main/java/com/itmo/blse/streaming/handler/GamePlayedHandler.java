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
        Match match = matchRepository.getMatchById(model.getMatchPublicId());
        Team winner = teamRepository.getTeamById(model.getWinnerPublicId());
        Game game = gameRepository.getGameById(model.getPublicId());
        game.setMatch(match);
        game.setWinner(winner);
        gameRepository.save(game);
    }
}
