package org.bhoopendra.apps.shiro.auth;

import org.apache.shiro.realm.jdbc.JdbcRealm;

public class JDBCRealm extends JdbcRealm {

	private static final String AUTHENTICATION_QUERY = "select PASSWORD from USERTable u where u.USERNAME=?";

	public JDBCRealm() {
		this(new CoonectionDataSource());
	}

	public JDBCRealm(CoonectionDataSource coonectionDataSource) {
		this.setDataSource(coonectionDataSource);
		this.setAuthenticationQuery(AUTHENTICATION_QUERY);
	}

	public String getAuthenticationQuery() {
		return authenticationQuery;
	}

}
