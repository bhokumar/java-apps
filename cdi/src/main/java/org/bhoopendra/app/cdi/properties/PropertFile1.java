package org.bhoopendra.app.cdi.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertFile1 extends Properties {
	private static final long serialVersionUID = -6855507345685674722L;
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		FileInputStream fileInputStream = new FileInputStream("client/config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		System.out.println(properties.getProperty("dbpassword"));
		File file = new File("client/config.properties");
		if(file.isFile()){
			System.out.println("File Exists");
		}
		//propertFile1.store(new OutputStreamWriter(new FileOutputStream(PropertFile1.class.getClassLoader().getResource("client/sdk.properties").getPath()), "UTF-8"),"");
	}
}
