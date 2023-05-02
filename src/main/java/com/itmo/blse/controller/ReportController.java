package com.itmo.blse.controller;


import com.itmo.blse.model.Team;
import com.itmo.blse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/teams", produces = "application/json")
public class ReportController {

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public List<Team> getTeams() {
        return teamService.listTeams();
    }
}
