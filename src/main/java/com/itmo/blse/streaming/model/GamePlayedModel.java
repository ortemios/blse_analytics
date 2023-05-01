package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GamePlayedModel {
    private UUID publicId;
    private UUID matchPublicId;
    private UUID winnerPublicId;
}
