package login.authentication.bean;

public class Credententials implements School {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2887907150933735102L;
	private String userName;
	private String password;
	Credententials() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Credententials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
}
