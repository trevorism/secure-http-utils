package com.trevorism.https;

import com.trevorism.http.HeadersHttpResponse;
import com.trevorism.http.HttpClient;
import com.trevorism.http.JsonHttpClient;
import com.trevorism.https.token.ObtainTokenStrategy;

import java.util.HashMap;
import java.util.Map;

public abstract class SecureHttpClientBase implements SecureHttpClient {

    private final HttpClient httpClient;
    private final ObtainTokenStrategy obtainTokenStrategy;

    public SecureHttpClientBase(ObtainTokenStrategy strategy) {
        this(new JsonHttpClient(), strategy);
    }

    public SecureHttpClientBase(HttpClient delegate, ObtainTokenStrategy strategy) {
        httpClient = delegate;
        obtainTokenStrategy = strategy;
        obtainTokenStrategy.setHttpClient(httpClient);
    }

    @Override
    public HeadersHttpResponse get(String url, Map<String, String> map) {
        return httpClient.get(url, map);
    }

    @Override
    public String get(String url) {
        Map<String, String> headersMap = createHeaderMap();
        HeadersHttpResponse response = get(url, headersMap);
        return response.getValue();
    }

    @Override
    public HeadersHttpResponse post(String url, String serialized, Map<String, String> map) {
        return httpClient.post(url, serialized, map);
    }

    @Override
    public String post(String url, String serialized) {
        Map<String, String> headersMap = createHeaderMap();
        HeadersHttpResponse response = post(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public HeadersHttpResponse put(String url, String serialized, Map<String, String> map) {
        return httpClient.put(url, serialized, map);
    }

    @Override
    public String put(String url, String serialized) {
        Map<String, String> headersMap = createHeaderMap();
        HeadersHttpResponse response = put(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public String patch(String url, String serialized) {
        Map<String, String> headersMap = createHeaderMap();
        HeadersHttpResponse response = patch(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public HeadersHttpResponse patch(String url, String serialized, Map<String, String> map) {
        return httpClient.patch(url, serialized, map);
    }

    @Override
    public HeadersHttpResponse delete(String url, Map<String, String> map) {
        return httpClient.delete(url, map);
    }

    @Override
    public String delete(String url) {
        Map<String, String> headersMap = createHeaderMap();
        HeadersHttpResponse response = delete(url, headersMap);
        return response.getValue();
    }

    public ObtainTokenStrategy getObtainTokenStrategy() {
        return obtainTokenStrategy;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    protected Map<String, String> createHeaderMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(AUTHORIZATION, BEARER_ + obtainTokenStrategy.getToken());
        return headersMap;
    }
}
