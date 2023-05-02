package com.itmo.blse.controller;


import com.itmo.blse.dto.ReportDto;
import com.itmo.blse.error.ValidationError;
import com.itmo.blse.model.Report;
import com.itmo.blse.service.ReportService;
import com.itmo.blse.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/report")
public class ReportFileController {

    @Autowired
    ReportService reportService;

    @GetMapping("/{id}/")
    public ResponseEntity<?> getReports(@PathVariable Long id) throws IOException {
        try{

            Report report = reportService.getById(id);
            return makeResponse(report);
        }
        catch (ValidationError err){
            return ResponseEntity.badRequest().body(err.getErrors());
        }
    }

    @GetMapping("/latest/")
    public ResponseEntity<?> getReports() throws IOException {

        Report report = reportService.getLatest();
        return makeResponse(report);


    }

    public ResponseEntity<?> makeResponse(Report report) throws IOException{
        try{
            ResourceBundle resourceBundle = reportService.getResource(report);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resourceBundle.getFile().getName());
            return ResponseEntity.ok()
                    .contentLength(resourceBundle.getResource().contentLength())
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resourceBundle.getResource());
        }
        catch (ValidationError err){
            return ResponseEntity.badRequest().body(err.getErrors());
        }
    }

}
