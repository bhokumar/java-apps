package org.bhoopendra.task;

import java.util.Arrays;
import java.util.List;

public class DataCopy extends Thread {

	private Thread dataCopy;
	private String name;
	public DataCopy(String name) {
		super();
		this.name = name;
		System.out.println("Creating Thread : "+this.name);
	}
	@Override
	public void run() {
		List<Integer> list = Arrays.asList(1,2,3,4,55,6);
		for(int i=0;i<100;i++){
			System.out.println("Running Thread : ");
		}
		System.out.println("Exiting thread" +this.name);
	}
	
	public void start(){
		System.out.println("starting Thread : "+this.name);
		if(dataCopy==null){
			dataCopy = new Thread(this, this.name);
		}
		dataCopy.start();
	} 
	



}
