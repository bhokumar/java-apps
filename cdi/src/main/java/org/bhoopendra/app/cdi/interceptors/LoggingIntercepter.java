package org.bhoopendra.app.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logging
@Interceptor
public class LoggingIntercepter {
	@AroundInvoke
	public Object logging(final InvocationContext context) throws Exception {
		System.out.println("Logging Interceptor");
		return context.proceed();
	}

}
