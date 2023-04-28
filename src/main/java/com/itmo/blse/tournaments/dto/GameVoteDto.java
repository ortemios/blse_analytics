package com.itmo.blse.tournaments.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameVoteDto {
    private Long id;
    private Long judgeId;
    private Boolean isApproved;
}
