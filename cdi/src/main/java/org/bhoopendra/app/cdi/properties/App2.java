package org.bhoopendra.app.cdi.properties;

import java.io.FileOutputStream;
import java.io.IOException;

public class App2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("client/config.properties");
		fileOutputStream.write("".getBytes());
	}

}
