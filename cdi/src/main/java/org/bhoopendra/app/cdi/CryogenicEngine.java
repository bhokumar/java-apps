package org.bhoopendra.app.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class CryogenicEngine {
	void assemble() {
		System.out.println("Cryogenic Engine started!");
	}
}
