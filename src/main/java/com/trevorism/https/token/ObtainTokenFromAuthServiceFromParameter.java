package com.trevorism.https.token;

public class ObtainTokenFromAuthServiceFromParameter extends ObtainTokenFromAuthService {

    private final String clientId;
    private final String clientSecret;

    public ObtainTokenFromAuthServiceFromParameter(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    protected String getClientId() {
        return clientId;
    }

    @Override
    protected String getClientSecret() {
        return clientSecret;
    }
}
