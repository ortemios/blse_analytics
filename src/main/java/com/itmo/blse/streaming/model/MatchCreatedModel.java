package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MatchCreatedModel extends MatchModel {
    @Builder
    public MatchCreatedModel(
            UUID publicId,
            UUID team1PublicId,
            UUID team2PublicId
    ) {
        super(publicId, team1PublicId, team2PublicId);
    }
}
