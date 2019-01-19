package com.test;


@SuperFast @StandardFrameRelaySwitchingFlubber
public class SuperFastAtmtTransport implements ATMTransport {

private int retries;
	
	public void setRetries(int retries){
		this.retries = retries;
	}
	public void communicateWithBank() {
		 System.out.println("communicating with bank via the Super Fast transport " );
		
	}

}
