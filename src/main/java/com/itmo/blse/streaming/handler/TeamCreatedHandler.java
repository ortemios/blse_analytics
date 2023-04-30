package com.itmo.blse.streaming.handler;

import com.itmo.blse.streaming.event.TeamCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class TeamCreatedHandler implements EventHandler<TeamCreatedEvent> {


    @Override
    public void handle(TeamCreatedEvent event) {
        System.out.println("Handle " + event.getData().getName());
    }
}
