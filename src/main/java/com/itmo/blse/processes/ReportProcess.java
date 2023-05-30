package com.itmo.blse.processes;

import com.itmo.blse.service.AnalyticsReportMaker;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class ReportProcess implements JavaDelegate {

    @Autowired
    AnalyticsReportMaker analyticsReportMaker;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        analyticsReportMaker.makeReport();
    }
}