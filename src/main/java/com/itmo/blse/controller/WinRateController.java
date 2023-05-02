package com.itmo.blse.controller;

import com.itmo.blse.dto.WinRatioDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/winRate", produces = "application/json")
public class WinRateController {

    @Autowired
    StatsService statsService;

    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam UUID teamId) {
        try {
            double winRatio = statsService.getWinRate(teamId);
            return ResponseEntity.ok(WinRatioDto.builder().winRatio(winRatio));
        } catch (ValidationError err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrors());
        }
    }
}
