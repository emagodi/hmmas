package com.hmmas.core.exceptions;

public class BusinessExceptions extends RuntimeException {

    public BusinessExceptions(String message) {
        super(message);
    }

    public BusinessExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessExceptions(final Throwable cause) {
        super(cause);
    }
}
