package com.org.phasezero_catalog_service.Utility;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleResponseStructure {
    private int status;
    private String message;
}
