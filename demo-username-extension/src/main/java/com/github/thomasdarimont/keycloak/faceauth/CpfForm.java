package com.github.thomasdarimont.keycloak.faceauth;

import lombok.extern.jbosslog.JBossLog;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.authenticators.browser.UsernameForm;
import org.keycloak.broker.provider.util.SimpleHttp;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.KeycloakModelUtils;
import org.keycloak.services.managers.AuthenticationManager;
import org.keycloak.util.JsonSerialization;

import javax.ws.rs.RedirectionException;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Map;

@JBossLog
public class CpfForm implements Authenticator {

    static final String ID = "demo-cpf";

    private final KeycloakSession session;

    public CpfForm(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        Response response = context.form()
                .createForm("demo-cpf-form.ftl");
        context.challenge(response);
    }

    @Override
    public void action(AuthenticationFlowContext context) {

        boolean validUser = true;

        String cpf = context.getHttpRequest().getFormParameters().getFirst("cpf");
        UserModel user = buscarUsuario(context, cpf);
        if (validUser) {
            context.setUser(user);
            context.success();
            return;
        }
    }

    private UserModel buscarUsuario(AuthenticationFlowContext context, String cpf) {
        return session.users().getUserByEmail(context.getRealm(),"franca@franca.com");
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
    }

    @Override
    public void close() {
        // NOOP
    }
}
