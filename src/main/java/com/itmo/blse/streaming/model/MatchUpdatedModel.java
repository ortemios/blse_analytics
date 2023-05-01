package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchUpdatedModel extends MatchModel {

    private UUID winnerPublicId;

    @Builder
    public MatchUpdatedModel(
            UUID publicId,
            UUID team1PublicId,
            UUID team2PublicId,
            UUID winnerPublicId
    ) {
        super(publicId, team1PublicId, team2PublicId);
        this.winnerPublicId = winnerPublicId;
    }

}
