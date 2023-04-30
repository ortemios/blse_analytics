package com.itmo.blse.tournaments.streaming.converter;

import com.itmo.blse.app.streaming.EventDataConverter;
import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.tournaments.model.Tournament;
import com.itmo.blse.tournaments.streaming.model.TeamCreatedModel;
import com.itmo.blse.tournaments.streaming.model.TournamentCreatedModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamCreatedConverter implements EventDataConverter<Team, TeamCreatedModel> {


    @Override
    public TeamCreatedModel toEventData(Team team) {
        return TeamCreatedModel.builder()
                .publicId(team.getPublicId())
                .name(team.getName())
                .build();
    }
}


/*

{

"eventId": "uuid",
"createdAt": "2022-12-13",
"routingKey": "analytics.stats",
"action": "team-created",
"data": {
        "publicId": "uuid",
        "name": "asdasd",
    }

}

 */