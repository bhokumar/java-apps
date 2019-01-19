package org.bhoopendra.task.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.axway.task.WorkerThread;

public class ThreadPoolExecuterTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<String> commands = Arrays.asList("mkdir","cd","rm","ls","uname");
		for(String command:commands){
			Runnable worker = new WorkerThread(command);
			executorService.execute(worker);
		}
		executorService.shutdown();
		while(!executorService.isTerminated()){
			
		}
		System.out.println("Finished all threads");
	}

}
