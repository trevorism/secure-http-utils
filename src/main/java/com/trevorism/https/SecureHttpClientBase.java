package com.trevorism.https;

import com.trevorism.http.HeadersHttpResponse;
import com.trevorism.http.HttpClient;
import com.trevorism.http.JsonHttpClient;
import com.trevorism.https.token.ObtainTokenStrategy;

import java.util.HashMap;
import java.util.Map;

public class SecureHttpClientBase implements SecureHttpClient {

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
    public String get(String url) {
        return get(url, "");
    }

    @Override
    public HeadersHttpResponse get(String url, Map<String, String> map) {
        return httpClient.get(url, map);
    }

    @Override
    public String get(String url, String correlationId) {
        Map<String, String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        HeadersHttpResponse response = get(url, headersMap);
        return response.getValue();
    }

    @Override
    public String post(String url, String serialized) {
        return post(url, serialized, "");
    }

    @Override
    public HeadersHttpResponse post(String url, String serialized, Map<String, String> map) {
        return httpClient.post(url, serialized, map);
    }

    @Override
    public String post(String url, String serialized, String correlationId) {
        Map<String, String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        HeadersHttpResponse response = post(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public String put(String url, String serialized) {
        return put(url, serialized, "");
    }

    @Override
    public HeadersHttpResponse put(String url, String serialized, Map<String, String> map) {
        return httpClient.put(url, serialized, map);
    }

    @Override
    public String put(String url, String serialized, String correlationId) {
        Map<String, String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        HeadersHttpResponse response = put(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public String patch(String url, String serialized, String correlationId) {
        Map<String, String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        HeadersHttpResponse response = patch(url, serialized, headersMap);
        return response.getValue();
    }

    @Override
    public String patch(String url, String serialized) {
        return patch(url, serialized, "");
    }

    @Override
    public HeadersHttpResponse patch(String url, String serialized, Map<String, String> map) {
        return httpClient.patch(url, serialized, map);
    }

    @Override
    public String delete(String url) {
        return delete(url, "");
    }

    @Override
    public HeadersHttpResponse delete(String url, Map<String, String> map) {
        return httpClient.delete(url, map);
    }

    @Override
    public String delete(String url, String correlationId) {
        Map<String, String> headersMap = createHeaderMap(correlationId, obtainTokenStrategy.getToken());
        HeadersHttpResponse response = delete(url, headersMap);
        return response.getValue();
    }

    public ObtainTokenStrategy getObtainTokenStrategy() {
        return obtainTokenStrategy;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    private static Map<String, String> createHeaderMap(String correlationId, String token) {
        Map<String, String> headersMap = new HashMap<>();
        if (!correlationId.isEmpty())
            headersMap.put(SecureHttpClient.CORRELATION_ID_HEADER_KEY, correlationId);
        headersMap.put(AUTHORIZATION, BEARER_ + token);
        return headersMap;
    }
}
