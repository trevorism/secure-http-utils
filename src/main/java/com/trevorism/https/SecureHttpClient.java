package com.trevorism.https;

import com.trevorism.http.HttpClient;
import com.trevorism.https.token.ObtainTokenStrategy;

public interface SecureHttpClient extends HttpClient {

    ObtainTokenStrategy getObtainTokenStrategy();

    HttpClient getHttpClient();
}
