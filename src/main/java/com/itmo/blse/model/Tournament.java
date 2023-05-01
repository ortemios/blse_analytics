package com.itmo.blse.model;

import com.itmo.blse.streaming.model.MatchCreatedModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Tournament {
    UUID id;
    String name;
    Date startedAt;
    List<Team> teams;
    List<Match> matches;
}
