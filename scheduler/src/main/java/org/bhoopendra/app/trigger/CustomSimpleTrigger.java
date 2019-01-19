package org.bhoopendra.app.trigger;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

public class CustomSimpleTrigger implements Trigger {

	private static final long serialVersionUID = 5847925356601355581L;

	@Override
	public int compareTo(Trigger arg0) {
		return 0;
	}

	@Override
	public String getCalendarName() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Date getEndTime() {
		return null;
	}

	@Override
	public Date getFinalFireTime() {
		return null;
	}

	@Override
	public Date getFireTimeAfter(Date arg0) {
		return null;
	}

	@Override
	public JobDataMap getJobDataMap() {
		return null;
	}

	@Override
	public JobKey getJobKey() {
		return null;
	}

	@Override
	public TriggerKey getKey() {
		return null;
	}

	@Override
	public int getMisfireInstruction() {
		return 0;
	}

	@Override
	public Date getNextFireTime() {
		return null;
	}

	@Override
	public Date getPreviousFireTime() {
		return null;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public ScheduleBuilder<? extends Trigger> getScheduleBuilder() {
		return null;
	}

	@Override
	public Date getStartTime() {
		return null;
	}

	@Override
	public TriggerBuilder<? extends Trigger> getTriggerBuilder() {
		return null;
	}

	@Override
	public boolean mayFireAgain() {
		return false;
	}

}
