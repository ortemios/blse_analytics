package com.itmo.blse.tournaments.streaming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchModel {

    String publicId;
    String tournamentPublicId;
    String team1PublicId;
    String team2PublicId;


}
