package com.trevorism.https.token

import org.junit.jupiter.api.Test

class ObtainTokenFromParameterTest {
    @Test
    void testGetToken() {
        ObtainTokenFromParameter obtainTokenFromParameter = new ObtainTokenFromParameter("hello")
        assert "hello" == obtainTokenFromParameter.getToken()

    }
}
