package com.cineman1.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateMemberException1 extends RuntimeException {

    private final Map<String, String> errors = new LinkedHashMap<>();

    public DuplicateMemberException1(String field, String message) {
        super(message);
        this.errors.put(field, message);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
