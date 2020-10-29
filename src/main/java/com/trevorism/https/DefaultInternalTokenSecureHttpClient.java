package com.trevorism.https;

import com.trevorism.https.token.ObtainTokenFromPropertiesFile;

public class DefaultInternalTokenSecureHttpClient extends SecureHttpClientBase {

    public DefaultInternalTokenSecureHttpClient() {
        super(new ObtainTokenFromPropertiesFile());
    }
}
