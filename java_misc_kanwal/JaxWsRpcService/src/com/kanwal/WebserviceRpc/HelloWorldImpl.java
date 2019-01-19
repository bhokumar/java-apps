package com.kanwal.WebserviceRpc;

import javax.jws.WebService;


@WebService(endpointInterface="com.kanwal.WebserviceRpc.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		
		return "Hello World Jax-ws "+ name;
	}
	
	

}
