package login.authentication;

public class Authentication {

	private String userName;
	private String password;
	public Authentication() {
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
	public Authentication(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
}
