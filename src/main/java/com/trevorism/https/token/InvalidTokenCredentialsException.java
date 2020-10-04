package com.trevorism.https.token;

public class InvalidTokenCredentialsException extends RuntimeException {
    public InvalidTokenCredentialsException() {
        super("Bad Request to get token");
    }
}
