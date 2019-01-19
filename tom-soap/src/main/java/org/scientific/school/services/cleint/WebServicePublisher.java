package org.scientific.school.services.cleint;

import javax.xml.ws.Endpoint;

import org.scientific.school.services.impl.OSHandlerImpl;
import org.scientific.school.services.impl.ServerStatusImpl;

public class WebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8083/osType", new OSHandlerImpl());
		Endpoint.publish("http://localhost:8083/serverStatus", new ServerStatusImpl());
		System.out.println("services hosted!");
	}

}
