package com.test;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	
	
	//@Inject @SuperFast @StandardFrameRelaySwitchingFlubber
	//@Inject @Transport(type = TransportType.STANDARD)
	@Inject @TransportConfig(retries = 2)
	private ATMTransport transport;
	
/*	@Inject @Soap
	private ATMTransport soapTransport;
	
	@Inject @Json
	private ATMTransport jsonTransport;
	
	@Inject @Standard
	private ATMTransport standardTransport;*/
	
	
	private boolean useJSON = true;
	
	private boolean behindFireWall = true;
	
/*	@PostConstruct
	protected void init(){
		if(!behindFireWall){
			transport = standardTransport;
		}else{
			if(useJSON){
				transport = jsonTransport;
			}else{
				transport = soapTransport;
			}
		}
	}*/
	
/*@Inject
public AutomatedTellerMachineImpl(@Soap ATMTransport transport) {
		this.transport = transport;
	}
*/
/*	public void setTransport(ATMTransport transport){
		this.transport = transport;
	}*/
	
	
	
	public void deposit(BigDecimal bd) {
	System.out.println("deposit called");
	transport.communicateWithBank();
	}

	public void withdraw(BigDecimal bd) {
		System.out.println("withdraw called");
		transport.communicateWithBank();
		
	}

}
