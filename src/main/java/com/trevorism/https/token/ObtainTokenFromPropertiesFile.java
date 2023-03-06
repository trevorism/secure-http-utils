package com.trevorism.https.token;

import com.trevorism.ClasspathBasedPropertiesProvider;
import com.trevorism.PropertiesProvider;
import com.trevorism.http.HttpClient;

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
        this.propertiesProvider = new ClasspathBasedPropertiesProvider(fileName);
        this.propertyName = propertyName;
    }

    @Override
    public String getToken() {
        return propertiesProvider.getProperty(propertyName);
    }

    @Override
    public void setHttpClient(HttpClient client) {
        //not needed, other implementations may need a HttpClient
    }

}
