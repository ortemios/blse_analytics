package com.itmo.blse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TournamentStatsDto {
    UUID id;
    List<UUID> teamIds;
    Integer totalMatches;
    Integer totalGames;
    UUID winnerPublicId;
}
