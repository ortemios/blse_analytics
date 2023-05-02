package com.itmo.blse.config;

import com.itmo.blse.jobs.ReportJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Autowired
    private AutowiringJobFactory autowiringJobFactory;

    @Bean
    public JobFactory jobFactory() {
        return autowiringJobFactory;
    }

    @Bean
    public JobDetail myQuartzJobDetail() {
        return JobBuilder.newJob(ReportJob.class)
                .withIdentity("reportJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger myQuartzJobTrigger(JobDetail myQuartzJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(myQuartzJobDetail)
                .withIdentity("reportJobTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
                .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger myQuartzJobTrigger) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setJobDetails(myQuartzJobDetail());
        factory.setTriggers(myQuartzJobTrigger);
        return factory;
    }
}
