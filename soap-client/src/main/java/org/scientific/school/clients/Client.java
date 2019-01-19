package org.scientific.school.clients;

import org.scientific.school.services.impl.OSHandlerImplService;
import org.scientific.school.services.impl.ServerStatusImplService;

public class Client {

	public static void main(String[] args) {
		OSHandlerImplService handlerImplService = new OSHandlerImplService();
		System.out.println(handlerImplService.getOSHandlerImplPort().getOS());
		
		ServerStatusImplService statusImplService = new ServerStatusImplService();
		System.out.println(statusImplService.getServerStatusImplPort().getStatus());
	}

}
