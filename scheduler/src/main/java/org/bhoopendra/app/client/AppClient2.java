package org.bhoopendra.app.client;
import java.io.IOException;

import org.bhoopendra.app.job.CustomJob;
import org.bhoopendra.app.properties.PropertyHandler;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.DirectSchedulerFactory;

public class AppClient2 {
	public static void main(String[] args) throws SchedulerException, IOException {
		DirectSchedulerFactory schedulerFactory = DirectSchedulerFactory.getInstance();
		schedulerFactory.createVolatileScheduler(1);
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		JobBuilder jobBuilder = JobBuilder.newJob(CustomJob.class);
		JobDetail jobDetail = jobBuilder.build();
		Trigger trigger = TriggerBuilder.newTrigger().startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInMinutes(Integer
								.parseInt(PropertyHandler.getPropertyValue("interval", "sdk/scheduler.properties")))
						.repeatForever())
				.build();
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
