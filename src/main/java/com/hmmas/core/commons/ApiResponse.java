package com.hmmas.core.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private int status;
    private String message;
    private T result;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(int status, T result) {
        this.status = status;
        this.result = result;
    }

}
