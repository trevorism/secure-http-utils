package com.trevorism.https.token;

import com.trevorism.http.HttpClient;

public class ObtainTokenFromParameter implements ObtainTokenStrategy{

    private final String token;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setHttpClient(HttpClient client) {
        //not needed, other implementations may need a HttpClient
    }

    public ObtainTokenFromParameter(String token){
        this.token = token;
    }
}
