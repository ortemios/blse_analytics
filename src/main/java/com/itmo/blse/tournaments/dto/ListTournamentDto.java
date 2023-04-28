package com.itmo.blse.tournaments.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ListTournamentDto {
    Long id;
    String name;
    Date startDate;
    Integer maxJudges;
    Double approvalRatio;
    Integer maxGames;
    TeamDto winner;


}
