package com.demo.anthentication.authenticator.risk;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by joris on 11/11/2016.
 */
public class RiskAuthenticatorFactory implements AuthenticatorFactory {

    public static final String PROVIDER_ID = "risk-authentication";

    private static final Logger logger = LoggerFactory.getLogger(RiskAuthenticatorFactory.class);
    private static final RiskAuthenticator SINGLETON = new RiskAuthenticator();
    private static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.ALTERNATIVE,
            AuthenticationExecutionModel.Requirement.DISABLED};

    private static final List<ProviderConfigProperty> configProperties = new ArrayList<ProviderConfigProperty>();

    @Override
    public String getId() {
        logger.info("getId called ... returning " + PROVIDER_ID);
        return PROVIDER_ID;
    }

    @Override
    public Authenticator create(KeycloakSession session) {
        logger.info("create called ... returning " + SINGLETON);
        return SINGLETON;
    }


    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        logger.info("getRequirementChoices called ... returning " + REQUIREMENT_CHOICES);
        return REQUIREMENT_CHOICES;
    }

    @Override
    public boolean isUserSetupAllowed() {
        logger.info("isUserSetupAllowed called ... returning true");
        return true;
    }
    @Override
    public boolean isConfigurable() {
        boolean result = true;
        logger.info("isConfigurable called ... returning " + result);
        return result;
    }
    @Override
    public String getHelpText() {
        logger.info("getHelpText called ...");
        return "Validates an OTP sent by SMS.";
    }
    @Override
    public String getDisplayType() {
        String result = "Risk Authentication";
        logger.info("getDisplayType called ... returning " + result);
        return result;
    }
    @Override
    public String getReferenceCategory() {
        logger.info("getReferenceCategory called ... returning sms-auth-code");
        return "usuario-auth";
    }
    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        logger.info("getConfigProperties called ... returning " + configProperties);
        return configProperties;
    }
    @Override
    public void init(Config.Scope config) {
        logger.info("init called ... config.scope = " + config);
    }
    @Override
    public void postInit(KeycloakSessionFactory factory) {
        logger.info("postInit called ... factory = " + factory);
    }
    @Override
    public void close() {
        logger.info("close called ...");
    }
}
