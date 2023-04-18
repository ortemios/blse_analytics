package com.itmo.blse.mapper;


import com.itmo.blse.dto.GameDto;
import com.itmo.blse.dto.GameVoteDto;
import com.itmo.blse.model.Game;
import com.itmo.blse.model.GameVote;
import com.itmo.blse.repository.GameVoteRepository;
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
