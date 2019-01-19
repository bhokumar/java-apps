package com.test;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@Transport(type=TransportType.STANDARD)
public class StandardAtmTransport implements ATMTransport {
	
	private int retries;
	
	public void setRetries(int retries){
		this.retries = retries;
	}

	public void communicateWithBank() {
		System.out.println("Communicating with bank via Standard transport"+ retries);
		
	}

}
