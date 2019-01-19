package org.bhoopendra.app.client;

import org.bhoopendra.app.job.CustomJob;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class AppClient {

	public static void main(String[] args) throws SchedulerException {
		AppClient appClient = new AppClient();
		appClient.fireJob();
	}

	private void fireJob() throws SchedulerException {
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		JobBuilder jobBuilder = JobBuilder.newJob(CustomJob.class);
		JobDataMap dataMap = new JobDataMap();
		dataMap.put("latch", this);
		JobDetail jobDetail = jobBuilder.usingJobData("example", "org.bhoopendra.app.client.AppClient")
				.usingJobData(dataMap).withIdentity("myJob", "group1").build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(50).withIntervalInSeconds(5))
				.build();
		scheduler.scheduleJob(jobDetail, trigger);
	}

}
