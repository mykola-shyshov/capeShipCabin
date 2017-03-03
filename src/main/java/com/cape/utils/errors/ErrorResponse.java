package com.cape.utils.errors;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private String message;

    private HttpStatus status;

    private int statusCode;

    public ErrorResponse( ApiException apiException ) {
        this.message = apiException.getDescription();
        this.status = apiException.getStatusCode();
        this.statusCode = status.value();
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }
}