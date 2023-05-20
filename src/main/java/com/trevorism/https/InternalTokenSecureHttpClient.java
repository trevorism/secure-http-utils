package com.trevorism.https;

import com.trevorism.https.token.ObtainTokenFromPropertiesFile;

public class InternalTokenSecureHttpClient extends SecureHttpClientBase {

    public InternalTokenSecureHttpClient() {
        super(new ObtainTokenFromPropertiesFile());
    }
}
