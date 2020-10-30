package com.trevorism.https.token;

import com.trevorism.secure.validator.Validators;

import javax.ws.rs.container.ContainerRequestContext;

public class ObtainTokenFromBearerValidators implements ObtainTokenStrategy {

    private final ContainerRequestContext context;

    public ObtainTokenFromBearerValidators(ContainerRequestContext context) {
        this.context = context;
    }

    @Override
    public String getToken() {
        try {
            return Validators.bearerTokenValidator.getAuthorizationString(context);
        } catch (Exception ignored) {
            return Validators.cookieValidator.getAuthorizationString(context);
        }

    }
}
