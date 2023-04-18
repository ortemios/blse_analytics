package com.itmo.blse.validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itmo.blse.dto.CreateTournamentDto;
import com.itmo.blse.errors.ValidationError;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.User;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreateTournamentValidator {

    @Autowired
    @JsonIgnore
    UserRepository userRepository;
    @Autowired
    @JsonIgnore
    TeamRepository teamRepository;

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

        if (errors.size() != 0) throw new ValidationError(errors);

        createTournamentDto.setJudges(foundJudges);
        createTournamentDto.setTeams(foundTeams);
    }
}
