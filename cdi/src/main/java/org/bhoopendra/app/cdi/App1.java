package org.bhoopendra.app.cdi;


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

public class App1 {
	
	@Inject
	CryogenicEngine cryogenicEngine;
	
	public static void main(String[] args) {
		App1 app1 = new App1();
		app1.execute();
	}
	
	private void execute() {
		final WebBeansContext beansContext = WebBeansContext.getInstance();
		ContainerLifecycle lifecycle = beansContext.getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);
		injectfields(this);
		cryogenicEngine.assemble();
		lifecycle.stopApplication(null);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void injectfields(final T targetObject){
		final BeanManager beanManager = CDI.current().getBeanManager();
		final AnnotatedType<T> annotatedType = (AnnotatedType<T>)beanManager.createAnnotatedType(targetObject.getClass());
		final InjectionTarget<T> injectionTarget = beanManager.createInjectionTarget(annotatedType);
		final Set<Bean<?>> beans = beanManager.getBeans(targetObject.getClass());
		final Bean<?> bean = beans.iterator().next();
		injectionTarget.inject(targetObject, (CreationalContext<T>)beanManager.createCreationalContext(bean));
	}
}
