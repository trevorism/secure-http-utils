package com.trevorism.https.token;

import com.trevorism.http.HttpClient;

public interface ObtainTokenStrategy {

    String DEFAULT_PROPERTIES_FILE_NAME = "secrets.properties";

    String getToken();

    void setHttpClient(HttpClient client);
}
