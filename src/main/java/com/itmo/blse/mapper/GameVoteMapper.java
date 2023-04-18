package com.itmo.blse.mapper;


import com.itmo.blse.dto.GameVoteDto;
import com.itmo.blse.dto.MatchDto;
import com.itmo.blse.model.GameVote;
import com.itmo.blse.model.Match;
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
