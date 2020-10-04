package com.trevorism.https

import org.junit.Test

class DefaultSecureHttpClientTest {
    @Test
    void testGet() {
        DefaultSecureHttpClient defaultSecureHttpClient = new DefaultSecureHttpClient()
        println defaultSecureHttpClient.get("auth.trevorism.com/user")
    }

    void testPost() {
    }

    void testPut() {
    }

    void testDelete() {
    }

    void testCreateHeaderMap() {
    }
}
