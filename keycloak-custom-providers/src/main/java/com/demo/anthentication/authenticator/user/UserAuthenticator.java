package com.demo.anthentication.authenticator.user;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

public class UserAuthenticator implements Authenticator {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticator.class);

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        logger.info("authenticate called ... context = " + context);

        Response challenge = context.form().createForm("sms-validation.ftl");
        context.challenge(challenge);

//        String a = "";
//        context.success();
    }

    @Override
    public void action(AuthenticationFlowContext context) {
        Response challenge = context.form()
                .setError("code is expired")
                .createForm("WEB-INF/sms-validation.ftl");
        context.failureChallenge(AuthenticationFlowError.EXPIRED_CODE, challenge);
    }


    @Override
    public boolean requiresUser() {
        logger.info("requiresUser called ... returning true");
        return true;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        logger.info("configuredFor called ... session=" + session + ", realm=" + realm + ", user=" + user);
        boolean result = true;
        logger.info("... returning " + result);
        return result;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        logger.info("setRequiredActions called ... session=" + session + ", realm=" + realm + ", user=" + user);
    }

    @Override
    public void close() {
        logger.info("close called ...");
    }

}
