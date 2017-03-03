package com.cape.utils.errors;

public class FieldErrorTO {

    private String field;

    private String code;

    private Object passedValue;

    private FieldErrorTO() {
        // for jackson deserialization purposes
    }

    public FieldErrorTO( String field, String code, Object passedValue ) {
        this.field = field;
        this.code = code;
        this.passedValue = passedValue;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

    public Object getPassedValue() {
        return passedValue;
    }
}
