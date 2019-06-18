package com.liulu.multipledatasource.quartz;

import com.liulu.multipledatasource.service.TestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

public class TestQuartz extends QuartzJobBean {

    @Autowired
    private TestService testService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(testService.findpage1().size());
        System.out.println(testService.findpage2().size());
        System.out.println(LocalDateTime.now());
    }
}
