package com.itmo.blse.streaming.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TournamentCreatedModel {

    private UUID publicId;
    private String name;
    private Date startedAt;
    private List<UUID> teams;
    private List<MatchCreatedModel> matches;


}
