package com.org.phasezero_catalog_service.Exception.Handler;


import com.org.phasezero_catalog_service.Exception.ProductNotFoundException;
import com.org.phasezero_catalog_service.Utility.ResponseBuilder;
import com.org.phasezero_catalog_service.Utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    ResponseEntity<SimpleErrorResponse> productNotFoundHandler(ProductNotFoundException e){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND,e.getMessage());
    }
}
