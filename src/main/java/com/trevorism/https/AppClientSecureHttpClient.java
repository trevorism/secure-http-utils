package com.trevorism.https;

import com.trevorism.https.token.ObtainTokenFromAuthServiceFromPropertiesFile;

public class AppClientSecureHttpClient extends SecureHttpClientBase {

    public AppClientSecureHttpClient() {
        super(new ObtainTokenFromAuthServiceFromPropertiesFile());
    }

}
