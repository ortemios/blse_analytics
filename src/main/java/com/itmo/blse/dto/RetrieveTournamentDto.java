package com.itmo.blse.dto;

import com.itmo.blse.model.Match;
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


    public static RetrieveTournamentDto fromTournament(Tournament tournament){
        return new RetrieveTournamentDtoBuilder()
                .id(tournament.getId())
                .name(tournament.getName())
                .start_date(tournament.getStartDate())
                .maxJudges(tournament.getMaxJudges())
                .judges(tournament.getJudges().stream().map(UserDto::fromUser).collect(Collectors.toList()))
                .teams(tournament.getTeams().stream().map(TeamDto::fromTeam).collect(Collectors.toList()))
                .matches(tournament.getMatches().stream().map(MatchDto::fromMatch).collect(Collectors.toList()))
                .build();
    }


}
