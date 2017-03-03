package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.UNAUTHORIZED )
public class UnauthorizedException extends ApiException {
    private static final HttpStatus STATUS = HttpStatus.UNAUTHORIZED;

    public UnauthorizedException( String msg ) {
        super( STATUS, msg );
    }

    public UnauthorizedException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public UnauthorizedException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public UnauthorizedException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
