package com.itmo.blse.tournaments.streaming.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class TournamentCreatedModel {

    private String publicId;
    private String name;
    private Date startedAt;
    private List<String> teams;
    private List<MatchCreatedModel> matches;


}
