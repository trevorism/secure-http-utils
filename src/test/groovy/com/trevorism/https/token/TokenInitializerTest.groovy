package com.trevorism.https.token

import com.trevorism.http.headers.HeadersHttpClient
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.entity.StringEntity
import org.junit.Test

class TokenInitializerTest {

    @Test
    void testGetToken() {
        TokenInitializer tokenInitializer = new TokenInitializer([post: {url, data, map ->
            return ([getEntity: { new StringEntity("token") }] as CloseableHttpResponse)
        }] as HeadersHttpClient)

        assert "token" == tokenInitializer.getToken()

    }

}
