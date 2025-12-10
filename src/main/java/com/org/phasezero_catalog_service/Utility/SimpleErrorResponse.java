package com.org.phasezero_catalog_service.Utility;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleErrorResponse {

    private String type;
    private int status;
    private String message;
}
