/*
 * Copyright (c) 2015 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.producer1;

import javax.enterprise.inject.Produces;

public class Factory {

	private static int count;

	@Produces
	public static Bar createBar() {
		return new Bar(String.valueOf(count++));
	}

	@Produces
	public static Foo createFoo(final Bar bar) {
		return new Foo(String.valueOf(count++), bar);
	}
}
