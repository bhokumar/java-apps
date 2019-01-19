/*
 * Copyright (c) 2015 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.producer1;

import static com.axway.dojo.cdi.tools.CDIUtils.injectFields;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.axway.dojo.cdi.bootstrap.Container;

public class ProducerMethodTest {

	private final Container bootstrap = new Container();

	@Inject
	private Foo foo;

	@After
	public void done() {
		bootstrap.stop();
	}

	@Before
	public void init() {
		bootstrap.start();
	}

	@Test
	public void test() {
		injectFields(this);
		foo.execute();
	}
}
