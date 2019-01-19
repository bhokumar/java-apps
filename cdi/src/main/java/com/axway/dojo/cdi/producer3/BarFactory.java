package com.axway.dojo.cdi.producer3;

import javax.enterprise.inject.Produces;

public class BarFactory {
	
	@Produces
	@BarProducer
	public Bar CreateBar() {
		System.out.println("Reached here");
		return new BarImpl();
	}

}
