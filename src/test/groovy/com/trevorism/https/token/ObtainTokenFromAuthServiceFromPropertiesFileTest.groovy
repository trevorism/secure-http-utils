package com.trevorism.https.token

import org.junit.Test

class ObtainTokenFromAuthServiceFromPropertiesFileTest {

    @Test(expected = InvalidTokenCredentialsException)
    void testGetTokenWithoutClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromPropertiesFile()
        assert obtainTokenFromAuthService.getToken()
    }

    @Test(expected = Exception)
    void testGetTokenWithBadClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromPropertiesFile("blah.props")
        assert obtainTokenFromAuthService.getToken()
    }
}
