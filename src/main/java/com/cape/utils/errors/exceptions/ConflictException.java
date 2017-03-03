package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.CONFLICT )
public class ConflictException extends ApiException {

    private static final HttpStatus STATUS = HttpStatus.CONFLICT;

    public ConflictException( String msg ) {
        super( STATUS, msg );
    }

    public ConflictException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public ConflictException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public ConflictException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
