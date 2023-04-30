package com.itmo.blse.streaming.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "action", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TeamCreatedEvent.class, name = "team-created"),
        @JsonSubTypes.Type(value = TournamentCreatedEvent.class, name = "tournament-created"),
        @JsonSubTypes.Type(value = MatchUpdatedEvent.class, name = "match-updated"),
        @JsonSubTypes.Type(value = GameDroppedEvent.class, name = "game-dropped"),
        @JsonSubTypes.Type(value = GamePlayedEvent.class, name = "game-played")
})

@Getter
@Setter
@NoArgsConstructor
public class Event {

    public String eventId;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime createdAt;
    public String routingKey;
    public String action;
}
