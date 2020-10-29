package com.trevorism.https.token;

import com.trevorism.secure.PropertiesProvider;

public class ObtainTokenFromAuthServiceFromPropertiesFile extends ObtainTokenFromAuthService{
    private static final String CLIENT_ID = "clientId";
    private static final String CLIENT_SECRET = "clientSecret";

    public ObtainTokenFromAuthServiceFromPropertiesFile() {
        this(DEFAULT_PROPERTIES_FILE_NAME);
    }

    public ObtainTokenFromAuthServiceFromPropertiesFile(String propertiesFileName) {
        PropertiesProvider propertiesProvider = new PropertiesProvider(propertiesFileName);
        setClientId(propertiesProvider.getProperty(CLIENT_ID));
        setClientSecret(propertiesProvider.getProperty(CLIENT_SECRET));
    }

}
