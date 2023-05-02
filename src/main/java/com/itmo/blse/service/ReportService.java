package com.itmo.blse.service;

import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Report;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.ReportRepository;
import com.itmo.blse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public List<Report> listReports(){
        return reportRepository.findAll();
    }

    public Report getById(Long id) throws ValidationError {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isEmpty()) {
            throw new ValidationError(List.of(String.format("Team with id %s not found", id)));
        }
        return report.get();
    }


}
