package com.mkyong.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.HelloWorld;

public class HelloWorldClient {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName qName = new QName("http://ws.mkyong.com/",  "HelloWorldImplService");
		Service service = Service.create(url, qName);
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		System.out.println(helloWorld.getHelloWorldAsString("kanwal"));
	}
}
