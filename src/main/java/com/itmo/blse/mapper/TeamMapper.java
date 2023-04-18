package com.itmo.blse.mapper;


import com.itmo.blse.dto.MatchDto;
import com.itmo.blse.dto.TeamDto;
import com.itmo.blse.model.Match;
import com.itmo.blse.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {


    public TeamDto toTeamDto(Team team){
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

}
