package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
public class IncorrectStateException extends ApiException {
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public IncorrectStateException( String msg ) {
        super( STATUS, msg );
    }

    public IncorrectStateException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public IncorrectStateException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public IncorrectStateException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
