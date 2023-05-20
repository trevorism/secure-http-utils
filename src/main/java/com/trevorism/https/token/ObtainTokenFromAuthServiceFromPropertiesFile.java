package com.trevorism.https.token;

import com.trevorism.ClasspathBasedPropertiesProvider;
import com.trevorism.PropertiesProvider;

public class ObtainTokenFromAuthServiceFromPropertiesFile extends ObtainTokenFromAuthService{

    private static final String CLIENT_ID = "clientId";
    private static final String CLIENT_SECRET = "clientSecret";

    private final PropertiesProvider propertiesProvider;

    public ObtainTokenFromAuthServiceFromPropertiesFile() {
        this(DEFAULT_PROPERTIES_FILE_NAME);
    }
    public ObtainTokenFromAuthServiceFromPropertiesFile(String propertiesFileName) {
        propertiesProvider = new ClasspathBasedPropertiesProvider(propertiesFileName);
    }

    @Override
    protected String getClientId() {
        return propertiesProvider.getProperty(CLIENT_ID);
    }

    @Override
    protected String getClientSecret() {
        return propertiesProvider.getProperty(CLIENT_SECRET);
    }
    
}
