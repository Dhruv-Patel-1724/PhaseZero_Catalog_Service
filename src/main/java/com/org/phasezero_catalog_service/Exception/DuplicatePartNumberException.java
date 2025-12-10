package com.org.phasezero_catalog_service.Exception;

public class DuplicatePartNumberException extends RuntimeException {
    public DuplicatePartNumberException(String message) {
        super(message);
    }
}
