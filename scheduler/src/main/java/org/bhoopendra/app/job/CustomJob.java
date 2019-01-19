package org.bhoopendra.app.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CustomJob implements Job {
private static int count = 0;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job executed !"+count++);
	}

}
