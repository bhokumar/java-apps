/*
 * Copyright (c) 2014 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.inject1;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.inject.spi.InjectionTarget;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.axway.dojo.cdi.bootstrap.Container;

public class ProgrammaticInjectionTest {

	private final Container container = new Container();

	@After
	public void done() {
		container.stop();
	}

	@Before
	public void init() {
		container.start();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		final Foo foo = new Foo();

		final BeanManager beanManager = CDI.current().getBeanManager();
		final AnnotatedType<Foo> annotatedType = beanManager
				.createAnnotatedType(Foo.class);
		final InjectionTarget<Foo> injectionTarget = beanManager
				.createInjectionTarget(annotatedType);
		final Set<Bean<?>> beans = beanManager.getBeans(Foo.class);
		final Bean<?> bean = beans.iterator().next();

		injectionTarget.inject(foo, (CreationalContext<Foo>) beanManager
				.createCreationalContext(bean));

		System.out.println(foo);
		foo.execute();
	}
}
