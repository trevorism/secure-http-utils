package com.trevorism.https.token

import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertThrows


class ObtainTokenFromPropertiesFileTest {

    @Test
    void testGetToken() {
        ObtainTokenFromPropertiesFile obtainTokenFromParameter = new ObtainTokenFromPropertiesFile()
        assert "asdf" == obtainTokenFromParameter.getToken()
    }

    @Test
    void testGetTokenMissingFile() {
        ObtainTokenFromPropertiesFile obtainTokenFromParameter = new ObtainTokenFromPropertiesFile("blah.props")
        assertThrows(Exception.class, () -> { obtainTokenFromAuthService.getToken() })

    }
}
