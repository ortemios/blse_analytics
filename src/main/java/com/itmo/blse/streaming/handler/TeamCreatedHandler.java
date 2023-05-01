package com.itmo.blse.streaming.handler;

import com.itmo.blse.model.Team;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.streaming.event.TeamCreatedEvent;
import com.itmo.blse.streaming.model.TeamCreatedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamCreatedHandler implements EventHandler<TeamCreatedEvent> {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public void handle(TeamCreatedEvent event) {
        TeamCreatedModel data = event.getData();
        Team team = new Team();
        team.setId(data.getPublicId());
        team.setName(data.getName());
        teamRepository.save(team);
    }
}
