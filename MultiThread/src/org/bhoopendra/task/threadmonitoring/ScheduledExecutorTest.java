package org.bhoopendra.task.threadmonitoring;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class ScheduledExecutorTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(4);
		ScheduledFuture<?> scheduledFuture = null;
		for (int i = 0; i < 10; i++) {
			scheduledFuture = poolExecutor.schedule(() -> {
				System.out.println("Worker called");
			}, 1, TimeUnit.SECONDS);
		}
		System.out.println(scheduledFuture.get());
		ScheduledFuture<String> future = poolExecutor.schedule(()->{return "Task1";}, 10, TimeUnit.MILLISECONDS);
		System.out.println(future.get());
		
		for(int i=0;i<10;i++){
			poolExecutor.scheduleAtFixedRate(()->{System.out.println("Task is scheduled at fix rate!");}, 10, 10, TimeUnit.MILLISECONDS);		
		}
		for(int i=0;i<10;i++){
			poolExecutor.scheduleWithFixedDelay(()->{System.out.println("Task is scheduled at fixed delay");}, 10, 10, TimeUnit.MILLISECONDS);
		}
		poolExecutor.shutdown();
	}

}
