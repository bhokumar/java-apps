package login.authentication.rest;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import login.authentication.bean.Credententials;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationHandler {
	public static Map<String, String> userTokenMap = new HashMap<>();
	@POST
	@Path("authenticate")
	public Response authenticate(final Credententials credententials) {
		try{
			authenticate(credententials.getUserName(), credententials.getPassword());
			final String token = issueToken(credententials.getUserName());
			return Response.ok(token).build();
		}catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	private void authenticate(final String userName,final String password){
		if(userName.equals("Mike")&&password.equals("Mike")){
			System.out.println("User Authenticated");
			return;
		}
		throw new  RuntimeException("Invalid Credentials");
	}
	private String issueToken(final String userName){
		final String token = new BigInteger(130, new SecureRandom()).toString(32); 
		userTokenMap.put(userName, token);
		return token;
	}
}
