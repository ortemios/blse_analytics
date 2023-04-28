package com.itmo.blse.tournaments.mapper;


import com.itmo.blse.tournaments.dto.GameVoteDto;
import com.itmo.blse.tournaments.model.GameVote;
import org.springframework.stereotype.Service;

@Service
public class GameVoteMapper {


    public GameVoteDto toGameVoteDto(GameVote gameVote){
        return GameVoteDto.builder()
                .id(gameVote.getId())
                .judgeId(gameVote.getJudge().getId())
                .isApproved(gameVote.isApproved())
                .build();

    }

}
