package org.bhoopendra.app.cdi.properties;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class App5 {

	public static void main(String[] args) throws IOException {
		FileUtils.touch(new File("client/test.properties"));
		File f = new File("client/test.properties");
		System.out.println(f.exists());
	}

}
