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

    public static MatchDto fromMatch(Match match){
        Long nextMatchId = null;
        Long team1Id = null;
        Long team2Id = null;
        if (match.getTeam1() != null) team1Id = match.getTeam1().getId();
        if (match.getTeam2() != null) team2Id = match.getTeam2().getId();
        if (match.getNextMatch() != null) nextMatchId = match.getNextMatch().getId();

        return MatchDto
                .builder()
                .id(match.getId())
                .team1Id(team1Id)
                .team2Id(team2Id)
                .nextMatchId(nextMatchId)
                .build();


    }






}
