package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alexey Tokar
 */
@ResponseStatus( HttpStatus.FORBIDDEN )
public class ForbiddenException extends ApiException {

    private static final HttpStatus STATUS = HttpStatus.FORBIDDEN;

    public ForbiddenException( String msg ) {
        super( STATUS, msg );
    }

    public ForbiddenException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public ForbiddenException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public ForbiddenException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
