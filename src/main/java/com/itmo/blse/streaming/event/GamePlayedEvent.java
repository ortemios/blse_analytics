package com.itmo.blse.streaming.event;

import com.itmo.blse.streaming.model.GamePlayedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GamePlayedEvent extends Event {
    GamePlayedModel data;
}
