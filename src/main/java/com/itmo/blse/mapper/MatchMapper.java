package com.itmo.blse.mapper;


import com.itmo.blse.dto.*;
import com.itmo.blse.model.Match;
import com.itmo.blse.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MatchMapper {

    @Autowired
    GameMapper gameMapper;

    @Autowired
    GameRepository gameRepository;

    public MatchDto toMatchDto(Match match){
        Long nextMatchId = null;
        Long team1Id = null;
        Long team2Id = null;
        if (match.getTeam1() != null) team1Id = match.getTeam1().getId();
        if (match.getTeam2() != null) team2Id = match.getTeam2().getId();
        if (match.getNextMatch() != null) nextMatchId = match.getNextMatch().getId();

        return MatchDto.builder()
                .id(match.getId())
                .team1Id(team1Id)
                .team2Id(team2Id)
                .nextMatchId(nextMatchId)
                .games(
                        gameRepository
                                .getGamesByMatch(match).stream()
                                .map(gameMapper::toGameDto)
                                .collect(Collectors.toList()
                                )
                )
                .build();

    }

}
