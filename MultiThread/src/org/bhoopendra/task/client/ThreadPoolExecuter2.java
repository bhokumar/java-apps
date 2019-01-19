package org.bhoopendra.task.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadPoolExecuter2 {

	public static void main(String[] args) {
		List<Callable<String>> commands = new ArrayList<>();
		commands.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task1";
			}
		});
		
		commands.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task2";
			}
		});
		
		commands.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task3";
			}
		});
		
		commands.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task4";
			}
		});
		
		commands.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task5";
			}
		});
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Copying data"+Thread.currentThread().getClass());
			}
		};
	}

}
