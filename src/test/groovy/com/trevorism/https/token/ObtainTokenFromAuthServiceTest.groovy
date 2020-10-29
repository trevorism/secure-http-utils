package com.trevorism.https.token

import org.junit.Test

class ObtainTokenFromAuthServiceTest {

    @Test(expected = InvalidTokenCredentialsException)
    void testGetTokenWithoutClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthService()
        assert obtainTokenFromAuthService.getToken()
    }

    @Test(expected = InvalidTokenCredentialsException)
    void testGetTokenWithBadClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthService()
        obtainTokenFromAuthService.clientId = "badClientId"
        obtainTokenFromAuthService.clientSecret = "badClientSecret"
        assert obtainTokenFromAuthService.getToken()
    }
}
