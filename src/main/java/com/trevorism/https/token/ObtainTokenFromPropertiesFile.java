package com.trevorism.https.token;

import com.trevorism.secure.PropertiesProvider;

public class ObtainTokenFromPropertiesFile implements ObtainTokenStrategy {

    private static final String DEFAULT_PROPERTY_NAME = "token";
    private final PropertiesProvider propertiesProvider;
    private final String propertyName;

    public ObtainTokenFromPropertiesFile() {
        this(DEFAULT_PROPERTIES_FILE_NAME);
    }

    public ObtainTokenFromPropertiesFile(String fileName) {
        this(fileName, DEFAULT_PROPERTY_NAME);
    }

    public ObtainTokenFromPropertiesFile(String fileName, String propertyName) {
        this.propertiesProvider = new PropertiesProvider(fileName);
        this.propertyName = propertyName;
    }

    @Override
    public String getToken() {
        return propertiesProvider.getProperty(propertyName);
    }

}
