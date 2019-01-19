package com.test;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransportFactory {

	@Produces
	ATMTransport createTransport(InjectionPoint injectionPoint){
		  System.out.println("annotated " + injectionPoint.getAnnotated());
	        System.out.println("bean " + injectionPoint.getBean());
	        System.out.println("member " + injectionPoint.getMember());
	        System.out.println("qualifiers " + injectionPoint.getQualifiers());
	        System.out.println("type " + injectionPoint.getType());
	        System.out.println("isDelegate " + injectionPoint.isDelegate());
	        System.out.println("isTransient " + injectionPoint.isTransient());
		return new StandardAtmTransport();
	}
}
