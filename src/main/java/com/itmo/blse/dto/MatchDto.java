package com.itmo.blse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class MatchDto {

    Long id;
    Long team1Id;
    Long team2Id;
    Long nextMatchId;
    List<GameDto> games;






}
