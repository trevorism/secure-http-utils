package com.trevorism.https.token;

import com.google.gson.Gson;
import com.trevorism.http.headers.HeadersHttpClient;
import com.trevorism.http.util.ResponseUtils;
import com.trevorism.secure.PropertiesProvider;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class ObtainTokenFromAuthService implements ObtainTokenStrategy{

    private static final int FIFTEEN_MINUTES_MILLIS = 1000 * 60 * 15;
    private static final String TOKEN_ENDPOINT = "https://auth.trevorism.com/token";
    private static final String CLIENT_ID = "clientId";
    private static final String CLIENT_SECRET = "clientSecret";

    private final HeadersHttpClient httpClient;
    private final Timer timer;
    private final Gson gson;
    private final PropertiesProvider propertiesProvider;

    private String token;

    public ObtainTokenFromAuthService(HeadersHttpClient httpClient) {
        this(httpClient, DEFAULT_PROPERTIES_FILE_NAME);
    }

    public ObtainTokenFromAuthService(HeadersHttpClient httpClient, String propertiesFileName) {
        this.httpClient = httpClient;
        this.gson = new Gson();
        this.timer = new Timer("token", true);
        this.propertiesProvider = new PropertiesProvider(propertiesFileName);
    }

    public String getToken() {
        if (token == null) {
            timer.schedule(new ExpireToken(), FIFTEEN_MINUTES_MILLIS);
            token = fetchToken();
        }
        return token;
    }

    private String fetchToken() {
        String clientId = propertiesProvider.getProperty(CLIENT_ID);
        String clientSecret = propertiesProvider.getProperty(CLIENT_SECRET);

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
