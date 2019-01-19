package login.authentication.rest;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		final String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null) {
			System.out.println("Authorization Header Must not be Empty");
			throw new NotAuthorizedException("Authorization Header Must not be Empty");
		}
		try {
			validateToken(authorizationHeader);
		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

	private void validateToken(String token) throws Exception {
		
		Collection<String> tokens = AuthenticationHandler.userTokenMap.values();
		int count=0;
		for(String token1 : tokens){
			if(token1.equals(token)){
				count++;
			}
		}
		if (count>0) {
			System.out.println("Successfully Authenticated!");
		} else {
			System.out.println("Token Authentication Failed");
			throw new NotAuthorizedException("Token is Invalid");
		}
	}
}
