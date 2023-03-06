package com.trevorism.https;

import com.trevorism.http.HttpClient;

public interface SecureHttpClient extends HttpClient {
    String AUTHORIZATION = "Authorization";
    String BEARER_ = "bearer ";
    String CORRELATION_ID_HEADER_KEY = "X-Correlation-ID";
    /**
     * Performs an HTTP GET
     *
     * @param url The url to GET
     * @return The string content of the response
     */
    String get(String url, String correlationId);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @return The string content of the response
     */
    String post(String url, String serialized, String correlationId);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @return The string content of the response
     */
    String put(String url, String serialized, String correlationId);

    /**
     * Performs an HTTP PATCH
     *
     * @param url        The url to PATCH
     * @param serialized The serialized item to PATCH
     * @return The string content of the response
     */
    String patch(String url, String serialized, String correlationId);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @return The string content of the response
     */
    String delete(String url, String correlationId);
}
