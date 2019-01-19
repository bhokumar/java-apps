package org.test;

import java.util.HashSet;

import sun.net.spi.nameservice.dns.DNSNameService;

public class App {
	public static void main(String[] args) {
		System.out.println(DNSNameService.class.getClassLoader());
		System.out.println(HashSet.class.getClassLoader());
		System.out.println(App.class.getClassLoader());
	}
}
