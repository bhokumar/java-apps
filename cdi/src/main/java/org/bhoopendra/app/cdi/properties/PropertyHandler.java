package org.bhoopendra.app.cdi.properties;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

public class PropertyHandler extends Properties {
	private static final long serialVersionUID = -7988137263570686797L;
	private static Logger logger = Logger.getLogger(PropertyHandler.class.getName());
	private static PropertyHandler propertyHandler = new PropertyHandler();
	private static final String PROPERTY_FILE = "tntProp/tntProps.properties";

	private PropertyHandler() {
		super();
	}

	public static void saveProperty(final String key, final String value, final String filePath) throws IOException {
		propertyHandler.clear();
		propertyHandler.load(PropertyHandler.class.getClassLoader().getResourceAsStream(filePath));
		propertyHandler.setProperty(key, value);
		propertyHandler.store(new OutputStreamWriter(
				new FileOutputStream(PropertyHandler.class.getClassLoader().getResource(filePath).getPath()), "UTF-8"),
				"");
	}

	public static String getPropertyValue(final String key, final String filePath) throws IOException {
		propertyHandler.clear();
		propertyHandler.load(PropertyHandler.class.getResourceAsStream(filePath));
		return propertyHandler.getProperty(key);
	}

	public static void managePropertyFiles() throws IOException {
		final String messagePrefix = "Property file : ";
		final String classPath = PropertyHandler.class.getClassLoader().getResource("").getPath();
		File file = new File(classPath + PROPERTY_FILE);
		if (!file.exists()) {
			logger.info(messagePrefix + PROPERTY_FILE + " does not exists!");
			FileUtils.touch(new File(classPath + PROPERTY_FILE));
			logger.info(messagePrefix + PROPERTY_FILE + " created!");
			manageDefaultProperties();
		} else {
			logger.info(messagePrefix + PROPERTY_FILE + " Already exists!");
		}
	}

	private static void manageDefaultProperties() throws IOException {
		final Map<String, String> defaultProperties = new HashMap<>();
		defaultProperties.put("com.axway.tnt.eu.sdk.token.interval", "5");
		defaultProperties.put("com.axway.tnt.eu.sdk.token.numberOftries", "3");
		defaultProperties.put("com.axway.tnt.eu.sdk.token.lastSuccessfullTime", "Not SuccessFull yet");
		defaultProperties.put("com.axway.tnt.eu.sdk.token.previousToken", "NA");
		defaultProperties.put("com.axway.tnt.eu.sdk.token.currentToken", "NA");
		defaultProperties.put("com.axway.tnt.eu.sdk.token.tempToken", "NA");
		saveProperty(defaultProperties, PROPERTY_FILE);
	}

	public static void saveProperty(final Map<String, String> defaultProperties, final String filePath)
			throws IOException {
		propertyHandler.clear();
		propertyHandler.load(PropertyHandler.class.getClassLoader().getResourceAsStream(filePath));
		final Set<Map.Entry<String, String>> entries = defaultProperties.entrySet();
		entries.stream().forEach(entry -> propertyHandler.setProperty(entry.getKey(), entry.getValue()));
		propertyHandler.store(new OutputStreamWriter(
				new FileOutputStream(PropertyHandler.class.getClassLoader().getResource(filePath).getPath()), "UTF-8"),
				"");
	}
}
