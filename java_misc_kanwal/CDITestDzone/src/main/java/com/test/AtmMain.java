package com.test;

import java.math.BigDecimal;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class AtmMain {
	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		AutomatedTellerMachine automatedTellerMachine =  (AutomatedTellerMachine) container.instance().select(AutomatedTellerMachineImpl.class).get();
		automatedTellerMachine.deposit(new BigDecimal("1.00"));
	}

}
