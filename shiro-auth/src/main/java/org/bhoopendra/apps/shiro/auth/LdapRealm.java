package org.bhoopendra.apps.shiro.auth;

import org.apache.shiro.realm.ldap.DefaultLdapRealm;

public class LdapRealm extends DefaultLdapRealm {
    private static final String USERNAME_TOKEN = "{USERNAME}";
    private final String initialContextFactory;

    private String url;
    private String userFilter;
    private String authIdentity;

    public LdapRealm() {
        this("com.sun.jndi.ldap.LdapCtxFactory");
    }

    public LdapRealm(final String initialContextFactory) {
        super();
        this.setAuthenticationCachingEnabled(false);
        this.initialContextFactory = initialContextFactory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }

    public String getAuthIdentity() {
        return authIdentity;
    }

    public void setAuthIdentity(String authIdentity) {
        this.authIdentity = authIdentity;
    }
}
