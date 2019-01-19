package org.bhoopendra.app.cdi.interceptors;

public class UserManager {

	public UserManager() {
	}

	private String userName;

	public UserManager(final String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void printUserName() {
		System.out.println("User Name : " + userName);
	}

}
