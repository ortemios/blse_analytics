package com.itmo.blse.tournaments.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itmo.blse.tournaments.model.Team;
import com.itmo.blse.users.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Builder
public class CreateTournamentDto {


    String name;

    Date startDate;

    List<Long> judgesIds;

    List<Long> teamsIds;

    Double approvalRatio;

    Integer maxGames;

    @JsonIgnore
    List<User> judges;

    @JsonIgnore
    List<Team> teams;



}
