package com.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("MyJob:" + dateFormat().format(new Date()));
    }
}