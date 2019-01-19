/*
 * Copyright (c) 2014 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.dojo.cdi.bootstrap;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class Container {

	private ContainerLifecycle lifecycle;

	public void start() {
		final WebBeansContext context = WebBeansContext.getInstance();
		lifecycle = context.getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);
	}

	public void stop() {
		lifecycle.stopApplication(null);
	}
}