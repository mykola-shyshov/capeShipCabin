package com.cape.utils.errors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationErrorTO {

    private List<FieldErrorTO> fieldErrors = new ArrayList<>();

    public ValidationErrorTO() {
    }

    public ValidationErrorTO( List<FieldErrorTO> fieldErrors ) {
        if ( fieldErrors != null ) {
            this.fieldErrors.addAll( fieldErrors );
        }
    }

    public void addFieldError( String field, String code, Object passedValue ) {
        fieldErrors.add( new FieldErrorTO( field, code, passedValue ) );
    }

    public List<FieldErrorTO> getFieldErrors() {
        return Collections.unmodifiableList( fieldErrors );
    }
}
