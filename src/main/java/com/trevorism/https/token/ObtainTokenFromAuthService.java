package com.trevorism.https.token;

import com.google.gson.Gson;
import com.trevorism.http.HttpClient;
import com.trevorism.http.JsonHttpClient;

import java.util.Timer;
import java.util.TimerTask;

public class ObtainTokenFromAuthService implements ObtainTokenStrategy {

    private static final int FIFTEEN_MINUTES_MILLIS = 1000 * 60 * 15;
    private static final String TOKEN_ENDPOINT = "https://auth.trevorism.com/token";

    private final Timer timer;
    private final Gson gson;

    private String token;

    private final HttpClient httpClient;
    private String clientId;
    private String clientSecret;

    public ObtainTokenFromAuthService() {
        this.httpClient = new JsonHttpClient();
        this.gson = new Gson();
        this.timer = new Timer("token", true);
    }

    public String getToken() {
        if (token == null) {
            timer.schedule(new ExpireToken(), FIFTEEN_MINUTES_MILLIS);
            token = fetchToken();
        }
        return token;
    }

    private String fetchToken() {
        if(clientId == null || clientSecret == null){
            throw new InvalidTokenCredentialsException();
        }

        TokenRequest tokenRequest = new TokenRequest(clientId, clientSecret);

        String json = gson.toJson(tokenRequest);
        String result = httpClient.post(TOKEN_ENDPOINT, json);
        if (result == null || result.startsWith("<html>")) {
            throw new InvalidTokenCredentialsException();
        }
        return result;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    private class ExpireToken extends TimerTask {

        @Override
        public void run() {
            token = null;
        }
    }
}
