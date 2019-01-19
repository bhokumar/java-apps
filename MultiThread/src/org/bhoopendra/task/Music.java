package org.bhoopendra.task;

public class Music implements Runnable {

	private Thread music;
	private String name;

	public Music(String name) {
		super();
		this.name = name;
		System.out.println("Creating Thread : "+this.name);
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Thread running : "+this.name);
		}
		System.out.println("Exiting thread" +this.name);
	}
	
	public void start(){
		System.out.println("starting Thread : "+this.name);
		if(music==null){
			music = new Thread(this, this.name);
		}
		music.start();
	}

}
