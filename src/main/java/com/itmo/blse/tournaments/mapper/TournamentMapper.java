package com.itmo.blse.tournaments.mapper;


import com.itmo.blse.tournaments.dto.*;
import com.itmo.blse.tournaments.model.Tournament;
import com.itmo.blse.tournaments.repository.MatchRepository;
import com.itmo.blse.users.mapper.UserMapper;
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
                .winner(tournament.getWinner() != null ? teamMapper.toTeamDto(tournament.getWinner()) : null)
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
                .approvalRatio(tournament.getApprovalRatio())
                .winner(tournament.getWinner() != null ? teamMapper.toTeamDto(tournament.getWinner()) : null)
                .maxGames(tournament.getMaxGames())
                .build();
    }

}
