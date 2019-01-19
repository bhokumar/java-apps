package org.bhoopendra.task.threadmonitoring;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class DaemonThread {
	public static void main(String[] args) {
		Runnable worker = new Runnable() {
			@Override
			public void run() {
				if (Thread.currentThread().isDaemon()) {
					System.out.println("Deomen Thread");
				}
			}
		};
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(2), Executors.defaultThreadFactory(),new RejectedExecutionHandlerImpl());
		poolExecutor.execute(worker);
	}
}
