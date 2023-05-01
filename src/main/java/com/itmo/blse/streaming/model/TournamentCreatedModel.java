package com.itmo.blse.streaming.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    private Date startedAt;
    private List<UUID> teams;
    private List<MatchCreatedModel> matches;
}
