package com.test;

import javax.enterprise.inject.Alternative;

@Transport(type=TransportType.JSON)
public class JsonRestAtmTransport implements ATMTransport {

private int retries;
	
	public void setRetries(int retries){
		this.retries = retries;
	}
	public void communicateWithBank() {
		 System.out.println("communicating with bank via JSON REST transport");
		
	}

}
