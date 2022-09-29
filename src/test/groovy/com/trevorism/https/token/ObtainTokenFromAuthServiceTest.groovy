package com.trevorism.https.token

import org.junit.Test

class ObtainTokenFromAuthServiceTest {

    @Test(expected = InvalidTokenCredentialsException)
    void testGetTokenWithoutClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromParameter(null, null)
        assert obtainTokenFromAuthService.getToken()
    }

    @Test(expected = InvalidTokenCredentialsException)
    void testGetTokenWithBadClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromParameter("badClientId", "badClientSecret")
        assert obtainTokenFromAuthService.getToken()
    }
}
