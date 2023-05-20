package com.trevorism.https.token;

import com.trevorism.http.HttpClient;

public class ObtainTokenFromParameter implements ObtainTokenStrategy{

    private String token;

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) { this.token = token; }

    @Override
    public void setHttpClient(HttpClient client) {
        //not needed, other implementations may need a HttpClient
    }

    public ObtainTokenFromParameter() {}
    public ObtainTokenFromParameter(String token){
        this.token = token;
    }
}
