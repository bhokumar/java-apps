package org.bhoopendra.app.cdi.interceptors;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class Client2 {
	public static void main(String[] args) {
		WebBeansContext beansContext = WebBeansContext.getInstance();
		ContainerLifecycle containerLifecycle = beansContext.getService(ContainerLifecycle.class);
		containerLifecycle.startApplication(null);
		final Application application = CDIUtils.getRefrence(Application.class);
		application.execute();
		containerLifecycle.stopApplication(null);
	}
}
