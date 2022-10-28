package com.hmmas.core.exceptions;

public class RecordNotFound extends RuntimeException {


    public RecordNotFound(String message) {
        super(message);
    }

    public RecordNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
