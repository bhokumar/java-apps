package org.scientific.school.services.impl;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.scientific.school.services.ServerStatus;

@WebService(endpointInterface="org.scientific.school.services.ServerStatus")
public class ServerStatusImpl implements ServerStatus{
	
	@Resource
	WebServiceContext  webServiceContext;
	
	@Override
	public String getStatus() {
		System.out.println("Server Status request hit");
		return "started";
	}

}
