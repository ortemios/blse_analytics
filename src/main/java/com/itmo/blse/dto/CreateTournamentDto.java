package com.itmo.blse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itmo.blse.model.Team;
import com.itmo.blse.model.Tournament;
import com.itmo.blse.model.User;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.repository.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CreateTournamentDto {

    String name;
    Date startDate;
    Integer maxJudges;
    List<Long> judgesIds;
    List<Long> teamsIds;
    @JsonIgnore
    List<User> judges;
    @JsonIgnore
    List<Team> teams;



}
