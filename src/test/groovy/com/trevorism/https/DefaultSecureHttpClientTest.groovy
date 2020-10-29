package com.trevorism.https

import com.trevorism.https.token.InvalidTokenCredentialsException
import com.trevorism.https.token.ObtainTokenFromInternal
import org.junit.Test

class DefaultSecureHttpClientTest {

    @Test(expected = InvalidTokenCredentialsException)
    void testGet() {
        DefaultSecureHttpClient defaultSecureHttpClient = new DefaultSecureHttpClient()
        assert defaultSecureHttpClient
        assert defaultSecureHttpClient.get("auth.trevorism.com/ping")
    }

    @Test
    void testGetWithoutAuth() {
        DefaultSecureHttpClient defaultSecureHttpClient = new DefaultSecureHttpClient(new ObtainTokenFromInternal())
        assert defaultSecureHttpClient
        assert "pong" == defaultSecureHttpClient.get("auth.trevorism.com/ping")
    }

    @Test(expected = Exception)
    void testGetBadUrl() {
        DefaultSecureHttpClient defaultSecureHttpClient = new DefaultSecureHttpClient(new ObtainTokenFromInternal())
        assert defaultSecureHttpClient
        println defaultSecureHttpClient.get("zyasd.trevorism.com/pin")
    }
}
