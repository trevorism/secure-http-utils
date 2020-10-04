package com.trevorism.https.token;

public class TokenRequest {

    private final String id;
    private final String password;
    private final String type = "app";

    TokenRequest(String clientId, String clientSecret){
        this.id = clientId;
        this.password = clientSecret;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

}
