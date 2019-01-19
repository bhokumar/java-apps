package org.bhoopendra.apps.shiro.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import static org.apache.shiro.config.IniFactorySupport.DEFAULT_INI_RESOURCE_PATH;

public class Authentication {

	public static void main(String[] args) {
		
		//set security manager instance
		//get shiro.ini from class path
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(DEFAULT_INI_RESOURCE_PATH);
		SecurityManager securityManager  = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject currentUser = SecurityUtils.getSubject();
		
		Session session = currentUser.getSession();
		session.setAttribute("currentUser", "bhoopendra");
		
		UsernamePasswordToken token =  new UsernamePasswordToken("bhoopendra","bhoopendra");
		if (!currentUser.isAuthenticated()) {
	            currentUser = new Subject.Builder().buildSubject();
	        }
		try {
			currentUser.login(token);
			System.out.println("login successful");
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		token.setRememberMe(true);
	}

}
