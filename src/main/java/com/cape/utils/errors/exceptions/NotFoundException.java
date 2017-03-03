package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND )
public class NotFoundException extends ApiException {
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException( String msg ) {
        super( STATUS, msg );
    }

    public NotFoundException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public NotFoundException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public NotFoundException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
