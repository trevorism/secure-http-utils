package com.trevorism.https.token

import org.junit.Test

class ObtainTokenFromPropertiesFileTest {

    @Test
    void testGetToken() {
        ObtainTokenFromPropertiesFile obtainTokenFromParameter = new ObtainTokenFromPropertiesFile()
        assert "asdf" == obtainTokenFromParameter.getToken()
    }

    @Test(expected = Exception)
    void testGetTokenMissingFile() {
        ObtainTokenFromPropertiesFile obtainTokenFromParameter = new ObtainTokenFromPropertiesFile("blah.props")
        assert "asdf" == obtainTokenFromParameter.getToken()
    }
}
