package com.itmo.blse.streaming.event;

import com.itmo.blse.streaming.model.MatchUpdatedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchUpdatedEvent extends Event {
    MatchUpdatedModel data;
}
