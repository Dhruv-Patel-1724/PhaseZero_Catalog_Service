package com.org.phasezero_catalog_service.Dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private long id;

    private String partNumber;

    private String partName;

    private String category;

    private double price;

    private int stock;
}
