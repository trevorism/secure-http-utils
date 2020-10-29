package com.trevorism.https.token;

public class ObtainTokenFromParameter implements ObtainTokenStrategy{

    private final String token;

    @Override
    public String getToken() {
        return token;
    }

    public ObtainTokenFromParameter(String token){
        this.token = token;
    }
}
