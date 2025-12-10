package com.org.phasezero_catalog_service.Exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
