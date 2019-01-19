package org.bhoopendra.task.threadmonitoring;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorTest {
	public static void main(String[] args) throws InterruptedException {
		RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(2, true), threadFactory, rejectedExecutionHandler);
		CustomMonitorThread monitor = new CustomMonitorThread(threadPoolExecutor, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		Runnable worker = new Runnable() {

			@Override
			public void run() {
				System.out.println("Worker Thread is running!");
			}
		};
		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.execute(worker);
		}
		Thread.sleep(2000);
		threadPoolExecutor.shutdown();
		Thread.sleep(5000);
		monitor.shutDown();
	}

}
