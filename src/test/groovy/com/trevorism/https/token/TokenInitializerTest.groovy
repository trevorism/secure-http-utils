package com.trevorism.https.token

import com.trevorism.http.headers.HeadersJsonHttpClient
import org.junit.Test

class TokenInitializerTest {

    @Test
    void testGetToken() {
        TokenInitializer tokenInitializer = new TokenInitializer(new HeadersJsonHttpClient())

        println tokenInitializer.token

        Thread.sleep(2000)


        println tokenInitializer.token


    }

    void testFetchToken() {
    }
}
