package com.itmo.blse.streaming.event;

import com.itmo.blse.streaming.model.GameDroppedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDroppedEvent extends Event {
    GameDroppedModel data;
}
