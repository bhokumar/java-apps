/*
 * Copyright (c) 2014 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class Foo {

	@Inject
	private Event<String> event;

	public void execute() {
		event.fire(toString());
	}
}
