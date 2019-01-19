package org.bhoopendra.apps.shiro.auth;

import com.jolbox.bonecp.BoneCPDataSource;

public class CoonectionDataSource extends BoneCPDataSource {
	
	private static final long serialVersionUID = 1L;

	public CoonectionDataSource(final String dbUrl, final String dbUser, final String dbPwd, final String driver)
	    {
	        super();
	        this.setDriverClass(driver);
	        this.setJdbcUrl(dbUrl);
	        this.setUsername(dbUser);
	        this.setPassword(dbPwd);
	    }

	public CoonectionDataSource() {
		this("jdbc:oracle:thin:@10.151.13.1:1521:ORCL", "c##bhoopendra", "c##bhoopendra","oracle.jdbc.driver.OracleDriver" );
	}
	
}


	
