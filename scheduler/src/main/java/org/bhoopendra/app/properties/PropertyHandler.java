package org.bhoopendra.app.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PropertyHandler extends Properties {
	private static final long serialVersionUID = -5149999412913620839L;
	private static PropertyHandler propertyHandler = new PropertyHandler();

	private PropertyHandler() {
		super();
	}

	public static void saveProperty(final String key, final String value, final String filePath) throws IOException {
		propertyHandler.clear();
		propertyHandler.load(PropertyHandler.class.getClassLoader().getResourceAsStream(filePath));
		propertyHandler.setProperty(key, value);
		propertyHandler.store(new OutputStreamWriter(new FileOutputStream(PropertyHandler.class.getClassLoader().getResource(filePath).getPath()), "UTF-8"),"");
	}

	public static String getPropertyValue(final String key, final String filePath) throws IOException {
		propertyHandler.clear();
		propertyHandler.load(PropertyHandler.class.getClassLoader().getResourceAsStream(filePath));
		return propertyHandler.getProperty(key);
	}
}
