package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.BAD_REQUEST )
public class IncorrectParamException extends ApiException {
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public IncorrectParamException( String msg ) {
        super( STATUS, msg );
    }

    public IncorrectParamException( String format, Object... argArray ) {
        super( STATUS, format, argArray );
    }

    public IncorrectParamException( Throwable e, String format, Object... argArray ) {
        super( STATUS, e, format, argArray );
    }

    public IncorrectParamException( Throwable e, String description ) {
        super( STATUS, description, e );
    }
}
