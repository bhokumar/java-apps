package org.bhoopendra.app.cdi.interceptors;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class Client {
	@Inject
	private Application application;
	
	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
	
	public void run() {
		WebBeansContext beansContext = WebBeansContext.getInstance();
		ContainerLifecycle containerLifecycle = beansContext.getService(ContainerLifecycle.class);
		containerLifecycle.startApplication(null);
		injectFields(this);
		application.execute();
		containerLifecycle.stopApplication(null);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void injectFields(final T targetObject) {
		BeanManager beanManager = CDI.current().getBeanManager();
		final AnnotatedType<T> annotatedType = (AnnotatedType<T>) beanManager
				.createAnnotatedType(targetObject.getClass());
		final InjectionTarget<T> injectionTarget = beanManager.createInjectionTarget(annotatedType);
		final Set<Bean<?>> beans = beanManager.getBeans(targetObject.getClass());
		final Bean<?> bean = beans.iterator().next();
		injectionTarget.inject(targetObject, (CreationalContext<T>) beanManager.createCreationalContext(bean));
	}
}
