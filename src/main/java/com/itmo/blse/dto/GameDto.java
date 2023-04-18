package com.itmo.blse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GameDto {
    private Long id;
    private Long winnerId;
    private List<GameVoteDto> gameVotes;
}
