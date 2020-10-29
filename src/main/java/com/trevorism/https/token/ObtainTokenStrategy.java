package com.trevorism.https.token;

public interface ObtainTokenStrategy {

    String DEFAULT_PROPERTIES_FILE_NAME = "secrets.properties";

    String getToken();
}
