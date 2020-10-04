package com.trevorism.https;

public interface SecureHttpClient {

    /**
     * Performs an HTTP GET
     *
     * @param url The url to GET
     * @return The string content of the response
     */
    String get(String url);
    String get(String url, String correlationId);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @return The string content of the response
     */
    String post(String url, String serialized);
    String post(String url, String serialized, String correlationId);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @return The string content of the response
     */
    String put(String url, String serialized);
    String put(String url, String serialized, String correlationId);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @return The string content of the response
     */
    String delete(String url);
    String delete(String url, String correlationId);
}
