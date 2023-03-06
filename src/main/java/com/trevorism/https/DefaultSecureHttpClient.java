package com.trevorism.https;

import com.trevorism.http.HttpClient;
import com.trevorism.https.token.ObtainTokenFromAuthServiceFromPropertiesFile;

public class DefaultSecureHttpClient extends SecureHttpClientBase{

    public DefaultSecureHttpClient() {
        super(new ObtainTokenFromAuthServiceFromPropertiesFile());
    }

}
