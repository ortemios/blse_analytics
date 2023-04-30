package com.itmo.blse.streaming.handler;

import com.itmo.blse.streaming.event.TeamCreatedEvent;
import com.itmo.blse.streaming.event.TournamentCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class TournamentCreatedHandler implements EventHandler<TournamentCreatedEvent> {


    @Override
    public void handle(TournamentCreatedEvent event) {
        System.out.println("Handle " + event.getData().getName());
    }
}
