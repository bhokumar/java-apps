package org.bhoopendra.task;

public class WorkerThread implements Runnable{
	private String command;
	public WorkerThread(String command) {
		super();
		this.command = command;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
		        processCommand();
		        System.out.println(Thread.currentThread().getName()+" End.");
		    }

	private void processCommand() {
		if(this.command.equals("mkdir")){
			System.out.println("*******************Creating Directory *************************");
		}else if(this.command.equals("rm")){
			System.out.println("*******************************removiving directory or file ******************");
		}else if(this.command.equals("ls")){
			System.out.println("************************Listing Directory ************************");
		}else if(this.command.equals("cd")){
			System.out.println("*********************Changing Directory **********************");
		}else{
			System.out.println("**************************Invalid Command ******************************");
		}
	}

}

