package com.itmo.blse.service;

import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Report;
import com.itmo.blse.model.Team;
import com.itmo.blse.repository.ReportRepository;
import com.itmo.blse.repository.TeamRepository;
import com.itmo.blse.util.ResourceBundle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public Report getLatest(){
        return reportRepository.findFirstByOrderByCreatedDesc();
    }

    public ResourceBundle getResource(Report report) throws ValidationError{
        File file = new File(report.getFilepath());
        try {
            Resource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
            return ResourceBundle.builder().resource(resource).file(file).build();
        }
        catch (IOException ex){
            throw new ValidationError(List.of("Resource corrupted"));
        }
    }


}
