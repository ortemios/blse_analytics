package com.itmo.blse.config;


import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class AutowiringJobFactory implements JobFactory {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        Job job = null;
        try {
            job = bundle.getJobDetail().getJobClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        applicationContext.getAutowireCapableBeanFactory().autowireBean(job);
        return job;
    }
}
