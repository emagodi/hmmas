package com.hmmas.core.exceptions;

public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(final Throwable cause) {
        super(cause);
    }

}
