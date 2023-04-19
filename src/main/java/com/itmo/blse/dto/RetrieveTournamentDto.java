package com.itmo.blse.dto;

import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
