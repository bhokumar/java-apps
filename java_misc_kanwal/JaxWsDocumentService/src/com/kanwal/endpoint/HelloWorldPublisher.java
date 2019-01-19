package com.kanwal.endpoint;

import javax.xml.ws.Endpoint;

import com.kanwal.ws.HelloWorldImpl;

public class HelloWorldPublisher {
public static void main(String[] args) {
	Endpoint.publish("http://localhost:8080/ws/hello1", new HelloWorldImpl());
}
}
