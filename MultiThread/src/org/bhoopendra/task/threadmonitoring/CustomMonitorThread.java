package org.bhoopendra.task.threadmonitoring;

import java.util.concurrent.ThreadPoolExecutor;

public class CustomMonitorThread implements Runnable{

	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;
	
	
	public CustomMonitorThread(ThreadPoolExecutor executor, int seconds) {
		super();
		this.executor = executor;
		this.seconds = seconds;
	}

	public void shutDown(){
		this.run = false;
	}

	@Override
	public void run() {
		System.out.println(
                String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                    this.executor.getPoolSize(),
                    this.executor.getCorePoolSize(),
                    this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(),
                    this.executor.getTaskCount(),
                    this.executor.isShutdown(),
                    this.executor.isTerminated()));
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
	}

}
