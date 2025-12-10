package com.org.phasezero_catalog_service.Service;



import com.org.phasezero_catalog_service.Dto.Request.ProductRequest;
import com.org.phasezero_catalog_service.Dto.Response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> searchProducts(String keyword);

    List<ProductResponse> filterByCategory(String category);

    List<ProductResponse> sortByPriceAsc();

    double getTotalInventoryValue();
}
