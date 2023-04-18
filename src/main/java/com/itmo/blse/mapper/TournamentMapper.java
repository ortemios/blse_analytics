package com.itmo.blse.mapper;


import com.itmo.blse.dto.MatchDto;
import com.itmo.blse.dto.RetrieveTournamentDto;
import com.itmo.blse.dto.TeamDto;
import com.itmo.blse.dto.UserDto;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TournamentMapper {

    @Autowired
    MatchService matchService;

    public RetrieveTournamentDto toRetrieveTournamentDto(Tournament tournament){
        return RetrieveTournamentDto.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .start_date(tournament.getStartDate())
                .maxJudges(tournament.getMaxJudges())
                .judges(tournament.getJudges().stream().map(UserDto::fromUser).collect(Collectors.toList()))
                .teams(tournament.getTeams().stream().map(TeamDto::fromTeam).collect(Collectors.toList()))
                .matches(matchService.getTournamentMatches(tournament).stream().map(MatchDto::fromMatch).collect(Collectors.toList()))
                .build();
    }

}
