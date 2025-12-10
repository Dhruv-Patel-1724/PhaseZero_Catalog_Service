package com.org.phasezero_catalog_service.Controller;


import com.org.phasezero_catalog_service.Dto.Request.ProductRequest;
import com.org.phasezero_catalog_service.Dto.Response.ProductResponse;
import com.org.phasezero_catalog_service.Service.ProductService;
import com.org.phasezero_catalog_service.Utility.ListResponseStructure;
import com.org.phasezero_catalog_service.Utility.ResponseBuilder;
import com.org.phasezero_catalog_service.Utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    @PostMapping("product")
    public ResponseEntity<ResponseStructure<ProductResponse>> addProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse response = productService.addProduct(productRequest);
        return ResponseBuilder.success(HttpStatus.CREATED,"Product Created", response);
    }

    @PostMapping("product/all")
    public ResponseEntity<ListResponseStructure<ProductResponse>> getAllProducts(){
        List<ProductResponse> response = productService.getAllProducts();
        return ResponseBuilder.success(HttpStatus.OK,"Products Fetched Successfully", response);
    }

    @PostMapping("product/search")
    public ResponseEntity<ListResponseStructure<ProductResponse>> searchProducts(@RequestParam String keyword){
        List<ProductResponse> response = productService.searchProducts(keyword);
        return ResponseBuilder.success(HttpStatus.OK,"Products Found", response);
    }

    @PostMapping("product/filter")
    public ResponseEntity<ListResponseStructure<ProductResponse>> filterByCategory(@RequestParam String category){
        List<ProductResponse> response = productService.filterByCategory(category);
        return ResponseBuilder.success(HttpStatus.OK,"Products Filtered", response);
    }

    @PostMapping("product/sort-price")
    public ResponseEntity<ListResponseStructure<ProductResponse>> sortByPriceAsc(){
        List<ProductResponse> response = productService.sortByPriceAsc();
        return ResponseBuilder.success(HttpStatus.OK,"Products Sorted", response);
    }

    @PostMapping("product/total-value")
    public ResponseEntity<ResponseStructure<Double>> getTotalInventoryValue(){
        double response = productService.getTotalInventoryValue();
        return ResponseBuilder.success(HttpStatus.OK,"Total Inventory Value Calculated", response);
    }
}
