/*
 * Copyright (c) 2015 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.tools;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;

public class CDIUtils {

	@SuppressWarnings("unchecked")
	public static <T> void injectFields(T object) {
		final BeanManager beanManager = CDI.current().getBeanManager();
		final AnnotatedType<T> annotatedType = (AnnotatedType<T>) beanManager
				.createAnnotatedType(object.getClass());
		final InjectionTarget<T> injectionTarget = beanManager
				.createInjectionTarget(annotatedType);
		final Set<Bean<?>> beans = beanManager.getBeans(object.getClass());
		final Bean<?> bean = beans.iterator().next();

		injectionTarget.inject(object, (CreationalContext<T>) beanManager
				.createCreationalContext(bean));
	}
}
