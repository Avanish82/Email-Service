package com.restapi.filter;

/**
 * @author rajatjain on 24/08/20.
 * @project hfcservice
 */
public class JWTException extends Exception{
    public JWTException() {
        super();
    }

    public JWTException(String message) {
        super(message);
    }

    public JWTException(String message, Throwable cause) {
        super(message, cause);
    }

    public JWTException(Throwable cause) {
        super(cause);
    }

    protected JWTException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
