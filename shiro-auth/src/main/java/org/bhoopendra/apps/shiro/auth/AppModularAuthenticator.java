package org.bhoopendra.apps.shiro.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppModularAuthenticator extends ModularRealmAuthenticator {
    private static final Logger LOGGER = Logger.getLogger(AppModularAuthenticator.class.getName());

    @Override
    public AuthenticationInfo doMultiRealmAuthentication(final Collection<Realm> realms, final AuthenticationToken authenticationToken) {
        final AuthenticationStrategy authenticationStrategy = getAuthenticationStrategy();
        AuthenticationInfo authenticationInfo = authenticationStrategy.beforeAllAttempts(realms, authenticationToken);
        for (final Realm realm : realms) {
            if (realm.supports(authenticationToken)) {
                AuthenticationInfo info = null;
                Throwable exception = null;
                try {
                    authenticationInfo = realm.getAuthenticationInfo(authenticationToken);
                } catch (final LockedAccountException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                } catch (final AuthenticationException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                }
                authenticationInfo = authenticationStrategy.afterAttempt(realm, authenticationToken, info, authenticationInfo, exception);
            }
        }
        authenticationInfo = authenticationStrategy.afterAllAttempts(authenticationToken, authenticationInfo);
        return authenticationInfo;
    }
}
