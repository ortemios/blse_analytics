package com.itmo.blse.tournaments.mapper;


import com.itmo.blse.tournaments.dto.GameDto;
import com.itmo.blse.tournaments.model.Game;
import com.itmo.blse.tournaments.repository.GameVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GameMapper {

    @Autowired
    GameVoteMapper gameVoteMapper;

    @Autowired
    GameVoteRepository gameVoteRepository;


    public GameDto toGameDto(Game game){
        return GameDto.builder()
                .id(game.getId())
                .winnerId(game.getWinner().getId())
                .gameVotes(
                        gameVoteRepository
                                .getGameVotesByGame(game)
                                .stream()
                                .map(gameVoteMapper::toGameVoteDto)
                                .collect(Collectors.toList())
                )
                .build();


    }

}
