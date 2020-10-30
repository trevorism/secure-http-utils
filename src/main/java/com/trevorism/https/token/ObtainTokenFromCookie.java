package com.trevorism.https.token;

import com.trevorism.secure.validator.Validators;

import javax.ws.rs.container.ContainerRequestContext;

public class ObtainTokenFromCookie implements ObtainTokenStrategy {

    private final ContainerRequestContext context;

    public ObtainTokenFromCookie(ContainerRequestContext context){

        this.context = context;
    }

    @Override
    public String getToken() {
        return Validators.cookieValidator.getAuthorizationString(context);
    }
}
