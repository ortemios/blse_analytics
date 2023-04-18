package com.itmo.blse.dto;

import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TeamDto {
    Long id;
    String name;

    public static TeamDto fromTeam(Team team){
        return new TeamDtoBuilder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }


}
