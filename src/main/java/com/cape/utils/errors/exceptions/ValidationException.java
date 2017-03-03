package com.cape.utils.errors.exceptions;

import com.cape.utils.errors.ValidationErrorTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.UNPROCESSABLE_ENTITY )
public class ValidationException extends RuntimeException {

    private ValidationErrorTO validationError;

    public ValidationErrorTO getValidationError() {
        return validationError;
    }

    public ValidationException( ValidationErrorTO validationError ) {
        this.validationError = validationError;
    }
}
