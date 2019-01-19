package com.kanwal.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.kanwal.ws.HelloWorld;

public class HelloWorldClient {
public static void main(String[] args) throws Exception {
URL url = new URL("http://localhost:8080/ws/hello1?wsdl");
QName qname = new QName("http://ws.kanwal.com/", "HelloWorldImplService");
Service service = Service.create(url, qname);
HelloWorld hello = service.getPort(HelloWorld.class);
System.out.println(hello.getHelloWorldAsString("Kanwal"));
}
}
