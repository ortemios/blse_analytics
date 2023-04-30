package com.itmo.blse.tournaments.streaming.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MatchCreatedModel extends MatchModel {

    @Builder
    public MatchCreatedModel(
            String publicId,
            String tournamentPublicId,
            String team1PublicId,
            String team2PublicId
    ){
        super(publicId, tournamentPublicId, team1PublicId, team2PublicId);
    }

}
