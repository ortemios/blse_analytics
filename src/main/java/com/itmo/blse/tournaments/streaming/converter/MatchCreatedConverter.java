package com.itmo.blse.tournaments.streaming.converter;

import com.itmo.blse.app.streaming.EventDataConverter;
import com.itmo.blse.tournaments.model.Match;
import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.tournaments.model.Tournament;
import com.itmo.blse.tournaments.streaming.model.MatchCreatedModel;
import com.itmo.blse.tournaments.streaming.model.TournamentCreatedModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MatchCreatedConverter implements EventDataConverter<Match, MatchCreatedModel> {


    @Override
    public MatchCreatedModel toEventData(Match match) {
        MatchCreatedModel.MatchCreatedModelBuilder builder = MatchCreatedModel.builder()
                .publicId(match.getPublicId())
                .tournamentPublicId(match.getTournament().getPublicId());

        if (match.getTeam1() != null)
            builder.team1PublicId(match.getTeam1().getPublicId());
        if (match.getTeam2() != null)
            builder.team2PublicId(match.getTeam2().getPublicId());

        return builder.build();

    }
}
