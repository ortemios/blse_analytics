package com.itmo.blse.tournaments.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MatchDto {

    Long id;
    Long team1Id;
    Long team2Id;
    Long nextMatchId;
    List<GameDto> games;






}
