package com.itmo.blse.tournaments.mapper;


import com.itmo.blse.tournaments.dto.TeamDto;
import com.itmo.blse.tournaments.model.Team;
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
