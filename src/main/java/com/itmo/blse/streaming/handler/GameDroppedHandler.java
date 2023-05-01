package com.itmo.blse.streaming.handler;

import com.itmo.blse.repository.GameRepository;
import com.itmo.blse.streaming.event.GameDroppedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class GameDroppedHandler implements EventHandler<GameDroppedEvent> {

    @Autowired
    GameRepository gameRepository;

    @Override
    public void handle(GameDroppedEvent event) throws Throwable{
        gameRepository.deleteById(event.getData().getPublicId());
    }
}
