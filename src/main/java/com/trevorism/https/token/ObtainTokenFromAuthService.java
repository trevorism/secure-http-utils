package com.trevorism.https.token;

import com.google.gson.Gson;
import com.trevorism.http.HttpClient;
import java.util.Timer;
import java.util.TimerTask;

public abstract class ObtainTokenFromAuthService implements ObtainTokenStrategy {

    private static final int FIFTEEN_MINUTES_MILLIS = 1000 * 60 * 15;
    private static final String TOKEN_ENDPOINT = "https://auth.trevorism.com/token";

    private final Timer timer;
    private final Gson gson;
    private HttpClient httpClient;

    private String token;

    public ObtainTokenFromAuthService() {
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

    @Override
    public void setHttpClient(HttpClient client) {
        this.httpClient = client;
    }

    private String fetchToken() {
        String clientId = getClientId();
        String clientSecret = getClientSecret();

        if(clientId == null || clientSecret == null){
            throw new InvalidTokenCredentialsException();
        }

        TokenRequest tokenRequest = new TokenRequest(clientId, clientSecret);

        String json = gson.toJson(tokenRequest);
        try {
            return httpClient.post(TOKEN_ENDPOINT, json);
        }catch(Exception e){
            throw new InvalidTokenCredentialsException(e);
        }
    }

    protected abstract String getClientId();
    protected abstract String getClientSecret();

    private class ExpireToken extends TimerTask {
        @Override
        public void run() {
            token = null;
        }
    }
}
