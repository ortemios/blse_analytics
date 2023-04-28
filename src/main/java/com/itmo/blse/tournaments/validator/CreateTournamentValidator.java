package com.itmo.blse.tournaments.validator;

import com.itmo.blse.tournaments.dto.CreateTournamentDto;
import com.itmo.blse.app.error.ValidationError;
import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.users.model.User;
import com.itmo.blse.tournaments.repository.TeamRepository;
import com.itmo.blse.tournaments.repository.TournamentRepository;
import com.itmo.blse.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreateTournamentValidator {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TournamentRepository tournamentRepository;

    public void clean(CreateTournamentDto createTournamentDto) throws ValidationError {
        List<User> foundJudges = userRepository.getAllByIdIn(createTournamentDto.getJudgesIds());
        List<Long> foundJudgesIds = foundJudges.stream().map(User::getId).collect(Collectors.toList());
        List<Long> invalidJudgesIds = createTournamentDto.getJudgesIds()
                .stream()
                .filter(jid -> !foundJudgesIds.contains(jid))
                .collect(Collectors.toList());
        List<Team> foundTeams = teamRepository.getAllByIdIn(createTournamentDto.getTeamsIds());
        List<Long> foundTeamsIds = foundTeams.stream().map(Team::getId).collect(Collectors.toList());
        List<Long> invalidTeamsIds = createTournamentDto.getTeamsIds()
                .stream()
                .filter(tid -> !foundTeamsIds.contains(tid))
                .collect(Collectors.toList());

        List<String> errors = new ArrayList<>();
        if (invalidJudgesIds.size() != 0)
            errors.add(String.format("Judges with ids %s not found", invalidJudgesIds));

        if (invalidTeamsIds.size() != 0)
            errors.add(String.format("Teams with ids %s not found", invalidTeamsIds));

        if (tournamentRepository.getTournamentByName(createTournamentDto.getName()) != null)
            errors.add(String.format("Tournament with name %s already exists", createTournamentDto.getName()));

        if (createTournamentDto.getJudgesIds().size() < 1 || createTournamentDto.getJudgesIds().size() > 10) {
            errors.add("Judges count should not be less than 1 or greater than 10");
        }

        if (createTournamentDto.getMaxGames() < 1 || createTournamentDto.getMaxGames() > 10) {
            errors.add("MaxGames should not be less than 1 or greater than 10");
        }

        if (createTournamentDto.getMaxGames() % 2 == 0) {
            errors.add("MaxGames should not be even");
        }

        if (errors.size() != 0) throw new ValidationError(errors);

        createTournamentDto.setJudges(foundJudges);
        createTournamentDto.setTeams(foundTeams);
    }
}
