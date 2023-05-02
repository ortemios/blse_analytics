package com.itmo.blse.jobs;

import com.itmo.blse.service.AnalyticsReportMaker;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class ReportJob extends QuartzJobBean {

    @Autowired
    AnalyticsReportMaker analyticsReportMaker;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        analyticsReportMaker.makeReport();

    }
}