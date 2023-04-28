package com.itmo.blse.tournaments.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamDto {
    Long id;
    String name;

}
