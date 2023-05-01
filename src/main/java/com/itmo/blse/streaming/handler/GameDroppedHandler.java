package com.itmo.blse.streaming.handler;

import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.streaming.event.GameDroppedEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class GameDroppedHandler implements EventHandler<GameDroppedEvent> {

    @Autowired
    GameRepository gameRepository;

    @Override
    public void handle(GameDroppedEvent event) {
        gameRepository.deleteById(event.getData().getPublicId());
    }
}
