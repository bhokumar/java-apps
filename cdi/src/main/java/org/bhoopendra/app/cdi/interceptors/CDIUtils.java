package org.bhoopendra.app.cdi.interceptors;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

public class CDIUtils {
	@SuppressWarnings("unchecked")
	public static <T> T getRefrence(final Class<T> clazz){
		final BeanManager beanManager =CDI.current().getBeanManager();
		final Set<Bean<?>> beans = beanManager.getBeans(clazz);
		final Bean<?> bean = beanManager.resolve(beans);
		final CreationalContext<T> creationalContext = beanManager.createCreationalContext((Bean<T>)bean);
		return (T) beanManager.getReference(bean, clazz, creationalContext);
	}
}
