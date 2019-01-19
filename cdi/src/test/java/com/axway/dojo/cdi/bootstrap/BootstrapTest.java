/*
 * Copyright (c) 2014 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.bootstrap;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BootstrapTest {

	private final Container container = new Container();

	@After
	public void done() {
		container.stop();
	}

	@Before
	public void init() {
		container.start();
	}

	@Test
	public void test() {
		final BeanManager beanManager = CDI.current().getBeanManager();
		final Set<Bean<?>> beans = beanManager.getBeans(Foo.class);
		for (final Bean<?> bean : beans) {
			System.out.println("Bean is: " + bean);
		}
	}
}
