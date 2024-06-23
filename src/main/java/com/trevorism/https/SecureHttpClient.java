package com.trevorism.https;

import com.trevorism.http.HttpClient;
import com.trevorism.https.token.ObtainTokenStrategy;

public interface SecureHttpClient extends HttpClient {

    String AUTHORIZATION = "Authorization";
    String BEARER_ = "Bearer ";

    ObtainTokenStrategy getObtainTokenStrategy();

    HttpClient getHttpClient();
}
