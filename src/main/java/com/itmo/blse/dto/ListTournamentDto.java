package com.itmo.blse.dto;

import com.itmo.blse.model.Tournament;
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


}
