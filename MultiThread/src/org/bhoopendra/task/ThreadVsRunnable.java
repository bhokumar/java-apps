package org.bhoopendra.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVsRunnable {

	public static void main(String[] args) {
		DataCopy dataCopy = new DataCopy("dataCopy");
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			executorService.execute(dataCopy);
		}
		executorService.shutdown();
	}

}
