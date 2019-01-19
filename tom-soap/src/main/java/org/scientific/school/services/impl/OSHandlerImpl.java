package org.scientific.school.services.impl;

import javax.jws.WebService;

import org.scientific.school.services.OSHandler;
@WebService(endpointInterface="org.scientific.school.services.OSHandler")
public class OSHandlerImpl implements OSHandler {

	@Override
	public String getOS() {
		System.out.println("OS Status request hit");
		return "Linux";
	}

}
