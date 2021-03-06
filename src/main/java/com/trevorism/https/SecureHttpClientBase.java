package com.trevorism.https;

import com.trevorism.http.headers.HeadersHttpClient;
import com.trevorism.http.headers.HeadersJsonHttpClient;
import com.trevorism.http.util.ResponseUtils;
import com.trevorism.https.token.ObtainTokenStrategy;

import java.util.HashMap;
import java.util.Map;

public class SecureHttpClientBase implements SecureHttpClient{

    protected final HeadersHttpClient httpClient;
    private final ObtainTokenStrategy obtainTokenStrategy;

    public SecureHttpClientBase(ObtainTokenStrategy strategy){
        httpClient = new HeadersJsonHttpClient();
        obtainTokenStrategy = strategy;
    }

    @Override
    public String get(String url) {
        return get(url, null);
    }

    @Override
    public String get(String url, String correlationId) {
        Map<String,String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        return ResponseUtils.getEntity(httpClient.get(url, headersMap));
    }

    @Override
    public String post(String url, String serialized) {
        return post(url, serialized, null);
    }

    @Override
    public String post(String url, String serialized, String correlationId) {
        Map<String,String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        return ResponseUtils.getEntity(httpClient.post(url, serialized, headersMap));
    }

    @Override
    public String put(String url, String serialized) {
        return put(url, serialized, null);
    }

    @Override
    public String put(String url, String serialized, String correlationId) {
        Map<String,String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        return ResponseUtils.getEntity(httpClient.put(url, serialized, headersMap));
    }

    @Override
    public String delete(String url) {
        return delete(url, null);
    }

    @Override
    public String delete(String url, String correlationId) {
        Map<String,String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        return ResponseUtils.getEntity(httpClient.delete(url, headersMap));
    }

    public ObtainTokenStrategy getObtainTokenStrategy() {
        return obtainTokenStrategy;
    }

    private static Map<String, String> createHeaderMap(String correlationId, String token) {
        Map<String, String> headersMap = new HashMap<>();
        if(correlationId != null)
            headersMap.put(HeadersHttpClient.CORRELATION_ID_HEADER_KEY, correlationId);
        headersMap.put(AUTHORIZATION, BEARER_ + token);
        return headersMap;
    }
}
