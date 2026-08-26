package com.trevorism.https;

import com.trevorism.https.token.ObtainTokenFromPropertiesFile;

public class LocalTokenSecureHttpClient extends SecureHttpClientBase {

    public LocalTokenSecureHttpClient() {
        super(new ObtainTokenFromPropertiesFile());
    }
}
