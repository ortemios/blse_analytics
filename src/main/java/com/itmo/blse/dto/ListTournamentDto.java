package com.itmo.blse.dto;

import com.itmo.blse.model.Tournament;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ListTournamentDto {
    Long id;
    String name;
    Date start_date;
    Integer maxJudges;

    public static ListTournamentDto fromTournament(Tournament tournament){
        return new ListTournamentDtoBuilder()
                .id(tournament.getId())
                .name(tournament.getName())
                .start_date(tournament.getStartDate())
                .maxJudges(tournament.getMaxJudges())
                .build();
    }


}
