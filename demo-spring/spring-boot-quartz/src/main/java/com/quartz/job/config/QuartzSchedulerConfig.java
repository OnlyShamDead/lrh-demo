package com.quartz.job.config;

import com.quartz.job.MyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzSchedulerConfig {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startMyJob(scheduler);
    }

    /*
        @Bean
        public JobDetail printTimeJobDetail(){
            return JobBuilder.newJob(DateTimeJob.class)//PrintTimeJob我们的业务类
                    .withIdentity("DateTimeJob")//可以给该JobDetail起一个id
                    //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                    .usingJobData("msg", "Hello Quartz")//关联键值对
                    .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                    .build();
        }
        @Bean
        public Trigger printTimeJobTrigger() {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
            return TriggerBuilder.newTrigger()
                    .forJob(printTimeJobDetail())//关联上述的JobDetail
                    .withIdentity("quartzTaskService")//给Trigger起个名字
                    .withSchedule(cronScheduleBuilder)
                    .build();
        }

    */

    private void startMyJob(Scheduler scheduler) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("MyJob", "group")
                .build();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ? *");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("MyTrigger", "group")
                .withSchedule(scheduleBuilder)
                .build();

        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

}