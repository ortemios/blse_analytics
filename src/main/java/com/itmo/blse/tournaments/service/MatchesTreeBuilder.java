package com.itmo.blse.tournaments.service;

import com.itmo.blse.tournaments.model.Match;
import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.tournaments.model.Tournament;
import com.itmo.blse.tournaments.repository.MatchRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@AllArgsConstructor
class Pair<T> {
    T first;
    T second;

    public List<T> toList() {
        ArrayList<T> list = new ArrayList<>();
        if (first != null) list.add(first);
        if (second != null) list.add(second);
        return list;
    }

}


@Service
public class MatchesTreeBuilder {

    @Autowired
    MatchRepository matchRepository;

    public void buildMatchesTree(Tournament tournament){

        List<Match> layer = buildInitialLayer(tournament);
        int layer_number = 1;
        while(layer.size() > 1){
            layer_number += 1;
            layer = buildNextLayer(layer, layer_number);
        }

    }

    private List<Match> buildNextLayer(List<Match> prevLayer, int layer){

        List<Pair<Match>> pairs = splitObjectsByPairs(prevLayer);
        List<Match> newLayer = new ArrayList<>();
        for (Pair<Match> pair: pairs){
            Match.MatchBuilder builder = Match.builder().tournament(pair.first.getTournament());
            if(pair.first.getTeam2() == null && layer == 2) builder.team1(pair.first.getTeam1());
            Match match = builder.build();
            matchRepository.save(match);
            pair.first.setNextMatch(match);
            if (pair.second != null)
                pair.second.setNextMatch(match);
            matchRepository.saveAll(pair.toList());
            newLayer.add(match);

        }
        return newLayer;

    }

    private List<Match> buildInitialLayer(Tournament tournament){
        ArrayList<Match> matches = new ArrayList<>();
        if (tournament.getTeams().size() == 0)
            throw new RuntimeException("Invalid tournament data");
        List<Pair<Team>> pairs = splitObjectsByPairs(tournament.getTeams());
        for(Pair<Team> pair: pairs){
            Match match = Match
                    .builder()
                    .tournament(tournament)
                    .team1(pair.getFirst())
                    .team2(pair.getSecond())
                    .build();
            matches.add(match);

        }
        matchRepository.saveAll(matches);
        return matches;


    }

    private <T> List<Pair<T>> splitObjectsByPairs(List<T> objects){
        List<Pair<T>> pairs = new ArrayList<>();
        int total = objects.size();
        if (total % 2 != 0){
            total -= 1;
            pairs.add(new Pair<>(objects.get(total), null));
        }

        for (int i = 0; i < total; i += 2){
            pairs.add(new Pair<>(objects.get(i), objects.get(i+1)));
        }
        return pairs;

    }



}
