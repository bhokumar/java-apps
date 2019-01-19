package org.bhoopendra.app.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logging
@Interceptor
public class AuthenticationIntercepter {
	@AroundInvoke
	public Object authenticate(InvocationContext context) throws Exception {
		System.out.println("authenticated");
		return context.proceed();
	}
}
