package com.trevorism.https

import com.trevorism.https.token.InvalidTokenCredentialsException
import org.junit.Test

class DefaultSecureHttpClientTest {

    @Test(expected = InvalidTokenCredentialsException)
    void testGet() {
        DefaultSecureHttpClient defaultSecureHttpClient = new DefaultSecureHttpClient()
        assert defaultSecureHttpClient
        assert defaultSecureHttpClient.get("auth.trevorism.com/ping")
    }

}
