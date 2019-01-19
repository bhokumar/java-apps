package org.bhoopendra.app.cdi.interceptors;

import javax.inject.Inject;

public class Application {
	
	@Inject 
	UserManager manager;
	
	@Logging
	public void execute() {
		System.out.println("Application running");
		manager.printUserName();
	}
}
