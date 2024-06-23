package com.trevorism.https.token

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertThrows

class ObtainTokenFromAuthServiceFromPropertiesFileTest {

    @Test
    void testGetTokenWithoutClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromPropertiesFile()
        assertThrows(InvalidTokenCredentialsException.class, () -> { obtainTokenFromAuthService.getToken() })
    }

    @Test
    void testGetTokenWithBadClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromPropertiesFile("blah.props")
        assertThrows(Exception.class, () -> { obtainTokenFromAuthService.getToken() })
    }
}
