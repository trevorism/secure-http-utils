package com.trevorism.https.token

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertThrows

class ObtainTokenFromAuthServiceTest {

    @Test
    void testGetTokenWithoutClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromParameter(null, null)
        assertThrows(InvalidTokenCredentialsException.class, () -> { obtainTokenFromAuthService.getToken() })

    }

    @Test
    void testGetTokenWithBadClientIdAndPassword() {
        ObtainTokenFromAuthService obtainTokenFromAuthService = new ObtainTokenFromAuthServiceFromParameter("badClientId", "badClientSecret")
        assertThrows(InvalidTokenCredentialsException.class, () -> { obtainTokenFromAuthService.getToken() })

    }
}
