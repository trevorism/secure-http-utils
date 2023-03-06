package com.trevorism.https.token;

public class InvalidTokenCredentialsException extends RuntimeException {
    public InvalidTokenCredentialsException() {
        super("Bad Request to get token");
    }
    public InvalidTokenCredentialsException(Throwable e) {
        super("Bad Request to get token", e);
    }
}
