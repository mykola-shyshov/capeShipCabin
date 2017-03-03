package com.cape.utils.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
public class ApiException extends RuntimeException {

    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected error";

    private final HttpStatus statusCode;

    private final String description;

    public ApiException() {
        this( HttpStatus.INTERNAL_SERVER_ERROR, UNEXPECTED_ERROR_MESSAGE );
    }

    public ApiException( Throwable cause ) {
        this( HttpStatus.INTERNAL_SERVER_ERROR, UNEXPECTED_ERROR_MESSAGE, cause );
    }

    public ApiException( HttpStatus statusCode, String description ) {
        super( description, null, true, false );
        this.statusCode = statusCode;
        this.description = description;
    }

    public ApiException( HttpStatus statusCode, String description, Throwable e ) {
        super( description, e, true, false );
        this.statusCode = statusCode;
        this.description = description;
    }

    public ApiException( HttpStatus statusCode, String format, Object... argArray ) {
        this( statusCode, MessageFormat.format( format, argArray ) );
    }

    public ApiException( HttpStatus statusCode, Throwable e, String format, Object... argArray ) {
        this( statusCode, MessageFormat.format( format, argArray ), e );
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }
}
