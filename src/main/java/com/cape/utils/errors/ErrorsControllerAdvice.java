package com.cape.utils.errors;

import com.cape.utils.errors.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@RequestMapping( produces = "application/json" )
public class ErrorsControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger( ErrorsControllerAdvice.class );

    @ExceptionHandler( { Exception.class } )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public ResponseEntity<ErrorResponse> handleExceptions(
            Exception exception
    ) {
        ApiException apiException;
        if ( exception instanceof ApiException ) {
            apiException = (ApiException) exception;
        } else {
            apiException = new ApiException( exception );
        }

        logger.error( "There was an error during request processing", apiException );

        return createResponseEntity( apiException );
    }

    @ExceptionHandler( MissingServletRequestParameterException.class )
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ResponseEntity<ErrorResponse> handleMissingParameter(
            MissingServletRequestParameterException exception
    ) {
        return createResponseEntity(
                new ApiException(
                        HttpStatus.BAD_REQUEST,
                        "Following required parameter is missing: " + exception.getParameterName()
                )
        );
    }

    @ExceptionHandler( MethodArgumentTypeMismatchException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public ResponseEntity<ErrorResponse> handleTypeMistmatch(
            MethodArgumentTypeMismatchException exception
    ) {
        return createResponseEntity(
                new ApiException( HttpStatus.NOT_FOUND, String.format(
                        "Incorrect value [%s] provided for property [%s]. Type needed: [%s]",
                        exception.getValue(),
                        exception.getName(),
                        exception.getRequiredType()
                ) )
        );
    }

    @ExceptionHandler( HttpRequestMethodNotSupportedException.class )
    @ResponseStatus( HttpStatus.METHOD_NOT_ALLOWED )
    public ResponseEntity<ErrorResponse> handleNotSupportedMethod(
            HttpRequestMethodNotSupportedException exception
    ) {
        return createResponseEntity(
                new ApiException(
                        HttpStatus.METHOD_NOT_ALLOWED,
                        "Only following methods are supported: " +
                                String.join( ",", (CharSequence[]) exception.getSupportedMethods() )
                )
        );
    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    @ResponseStatus( HttpStatus.UNPROCESSABLE_ENTITY )
    public ValidationErrorTO handleValidationException( MethodArgumentNotValidException ex ) {
        ValidationErrorTO validationErrors = new ValidationErrorTO();
        for ( FieldError error : ex.getBindingResult().getFieldErrors() ) {
            validationErrors.addFieldError(
                    error.getField(),
                    error.getCode(),
                    error.getRejectedValue()
            );
        }
        return validationErrors;
    }

    @ExceptionHandler( ValidationException.class )
    @ResponseStatus( HttpStatus.UNPROCESSABLE_ENTITY )
    public ValidationErrorTO handleValidationException( ValidationException ex ) {
        return ex.getValidationError();
    }

    private ResponseEntity<ErrorResponse> createResponseEntity( ApiException apiException ) {
        return ResponseEntity.status( apiException.getStatusCode() )
                             .body( new ErrorResponse( apiException ) );
    }

}
