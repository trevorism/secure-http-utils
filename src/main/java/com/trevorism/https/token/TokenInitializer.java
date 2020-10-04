package com.trevorism.https.token;

import com.google.gson.Gson;
import com.trevorism.http.headers.HeadersHttpClient;
import com.trevorism.http.util.ResponseUtils;
import com.trevorism.secure.PropertiesProvider;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TokenInitializer {

    public static final int FIFTEEN_MINUTES_MILLIS = 1000 * 60 * 15;
    public static final String TOKEN_ENDPOINT = "https://auth.trevorism.com/token";

    private final HeadersHttpClient httpClient;
    private final Timer timer;
    private final Gson gson;
    private final PropertiesProvider propertiesProvider;

    private String token;

    public TokenInitializer(HeadersHttpClient httpClient) {
        this.httpClient = httpClient;
        this.gson = new Gson();
        this.timer = new Timer("token", true);
        this.propertiesProvider = new PropertiesProvider();
    }

    public String getToken() {
        if (token == null) {
            timer.schedule(new ExpireToken(), FIFTEEN_MINUTES_MILLIS);
            token = fetchToken();
        }
        return token;
    }

    private String fetchToken() {
        String clientId = propertiesProvider.getProperty("clientId");
        String clientSecret = propertiesProvider.getProperty("clientSecret");

        TokenRequest tokenRequest = new TokenRequest(clientId, clientSecret);

        String json = gson.toJson(tokenRequest);
        String result = ResponseUtils.getEntity(httpClient.post(TOKEN_ENDPOINT, json, new HashMap<>()));
        if (result == null || result.startsWith("<html>")) {
            throw new InvalidTokenCredentialsException();
        }
        return result;
    }

    private class ExpireToken extends TimerTask {

        @Override
        public void run() {
            token = null;
        }
    }
}
