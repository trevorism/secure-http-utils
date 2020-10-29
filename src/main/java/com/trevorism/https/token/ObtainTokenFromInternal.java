package com.trevorism.https.token;

import com.trevorism.secure.PropertiesProvider;

public class ObtainTokenFromInternal implements ObtainTokenStrategy {

    private static final String TOKEN_PROPERTY = "token";
    private final PropertiesProvider propertiesProvider;
    
    public ObtainTokenFromInternal() {
        this(DEFAULT_PROPERTIES_FILE_NAME);
    }

    public ObtainTokenFromInternal(String fileName) {
        this.propertiesProvider = new PropertiesProvider(fileName);
    }

    @Override
    public String getToken() {
        return propertiesProvider.getProperty(TOKEN_PROPERTY);
    }

}
