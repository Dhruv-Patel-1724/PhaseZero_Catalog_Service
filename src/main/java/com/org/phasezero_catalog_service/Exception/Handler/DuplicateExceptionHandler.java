package com.org.phasezero_catalog_service.Exception.Handler;


import com.org.phasezero_catalog_service.Exception.DuplicatePartNumberException;
import com.org.phasezero_catalog_service.Utility.ResponseBuilder;
import com.org.phasezero_catalog_service.Utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DuplicateExceptionHandler {

    @ExceptionHandler(DuplicatePartNumberException.class)
    public ResponseEntity<SimpleErrorResponse> duplicatePartNumber(DuplicatePartNumberException e) {
        return ResponseBuilder.error(HttpStatus.CONFLICT, e.getMessage());
    }
}
