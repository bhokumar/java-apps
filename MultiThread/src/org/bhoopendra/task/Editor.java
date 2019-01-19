package org.bhoopendra.task;

public class Editor implements Runnable {
	private Thread editor;
	private String name;
	public Editor(String name) {
		super();
		this.name = name;
		System.out.println("Creating Thread : "+this.name);
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Running Thread : "+this.name);
		}
		System.out.println("Exiting thread" +this.name);
	}
	
	public void start(){
		System.out.println("starting Thread : "+this.name);
		if(editor==null){
			editor = new Thread(this, this.name);
		}
		editor.start();
	} 
	

}
