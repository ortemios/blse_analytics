package com.itmo.blse.tournaments.dto;

import com.itmo.blse.users.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class RetrieveTournamentDto {
    Long id;
    String name;
    Date start_date;
    Integer maxJudges;
    List<UserDto> judges;
    List<TeamDto> teams;
    List<MatchDto> matches;
    Double approvalRatio;
    Integer maxGames;
    TeamDto winner;


}
