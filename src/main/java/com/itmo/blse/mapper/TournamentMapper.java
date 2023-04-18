package com.itmo.blse.mapper;


import com.itmo.blse.dto.*;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TournamentMapper {

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    MatchMapper matchMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    UserMapper userMapper;

    public RetrieveTournamentDto toRetrieveTournamentDto(Tournament tournament){
        return RetrieveTournamentDto.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .start_date(tournament.getStartDate())
                .approvalRatio(tournament.getApprovalRatio())
                .maxGames(tournament.getMaxGames())
                .maxJudges(tournament.getMaxJudges())
                .judges(tournament.getJudges().stream().map(userMapper::toUserDto).collect(Collectors.toList()))
                .teams(tournament.getTeams().stream().map(teamMapper::toTeamDto).collect(Collectors.toList()))
                .matches(matchRepository.getAllByTournament(tournament).stream().map(matchMapper::toMatchDto).collect(Collectors.toList()))
                .build();
    }

    public ListTournamentDto toListTournamentDto(Tournament tournament){
        return ListTournamentDto.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .startDate(tournament.getStartDate())
                .maxJudges(tournament.getMaxJudges())
                .approvalRatio(tournament.getApprovalRatio())
                .maxGames(tournament.getMaxGames())
                .build();
    }

}
