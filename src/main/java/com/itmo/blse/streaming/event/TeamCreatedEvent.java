package com.itmo.blse.streaming.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.itmo.blse.streaming.model.TeamCreatedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
public class TeamCreatedEvent extends Event {
    TeamCreatedModel data;

}
