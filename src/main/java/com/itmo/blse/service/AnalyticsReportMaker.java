package com.itmo.blse.service;

import com.itmo.blse.model.Report;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.ReportRepository;
import com.itmo.blse.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AnalyticsReportMaker {

    @Autowired
    StatsService statsService;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ReportRepository reportRepository;

    @Transactional
    public void makeReport(){
        try{
            File reportFile = makeReportFile();
            Report report = Report.builder()
                    .filepath(reportFile.getPath())
                    .build();
            reportRepository.save(report);
        }
        catch (IOException ex){
            log.error("Report was not created due to IOException", ex);
        }
    };

    private File makeReportFile() throws IOException{
        File file = new File(String.format("reports/report-%s.csv", LocalDateTime.now()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String reportString = "teamId,teamName,opponentId,opponentName,gameWinProbability,matchWinRProbability\n";
        List<Team> teams = teamRepository.findAll();
        for (Team team1: teams){
            for (Team team2: teams){
                double gameWinProbability = statsService.getGameWinProbability(team1, team2);
            }
        }


        return file;
    }

}
