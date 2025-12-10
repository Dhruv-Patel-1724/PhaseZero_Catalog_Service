package com.org.phasezero_catalog_service.Mapper;


import com.org.phasezero_catalog_service.Dto.Request.ProductRequest;
import com.org.phasezero_catalog_service.Dto.Response.ProductResponse;
import com.org.phasezero_catalog_service.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {

    Product mapToProduct(ProductRequest productRequest);

    void mapToProductEntity(ProductRequest productRequest, @MappingTarget Product product);

    ProductResponse mapToProductResponse(Product product);

    List<ProductResponse> mapToProductResponse(List<Product> productList);
}
