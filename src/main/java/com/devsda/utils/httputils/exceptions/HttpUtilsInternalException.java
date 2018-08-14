package com.devsda.utils.httputils.exceptions;

public class HttpUtilsInternalException extends RuntimeException {

    public HttpUtilsInternalException(String message) {
        super(message);
    }

    public HttpUtilsInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpUtilsInternalException(Throwable cause) {
        super(cause);
    }
}
