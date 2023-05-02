package com.itmo.blse.controller;


import com.itmo.blse.dto.ReportDto;
import com.itmo.blse.model.Team;
import com.itmo.blse.service.ReportService;
import com.itmo.blse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/reports", produces = "application/json")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/")
    public List<ReportDto> getReports() {
        return reportService.listReports().stream().map(
                r -> new ReportDto(r.getId(), r.getCreated())
        ).collect(Collectors.toList());
    }

}
