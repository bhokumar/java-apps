package com.test;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@Transport(type=TransportType.SOAP)
public class SoapAtmTransport implements ATMTransport {

private int retries;
	
	public void setRetries(int retries){
		this.retries = retries;
	}
	public void communicateWithBank() {
		System.out.println("Communicating with bank via Soap transport");
		
	}
	

}
