package com.org.phasezero_catalog_service.Service;


import com.org.phasezero_catalog_service.Dto.Request.ProductRequest;
import com.org.phasezero_catalog_service.Dto.Response.ProductResponse;
import com.org.phasezero_catalog_service.Exception.DuplicatePartNumberException;
import com.org.phasezero_catalog_service.Exception.ProductNotFoundException;
import com.org.phasezero_catalog_service.Mapper.ProductMapper;
import com.org.phasezero_catalog_service.Model.Product;
import com.org.phasezero_catalog_service.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // 1) Add Product
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

        // Check duplicate partNumber
        if (productRepository.existsByPartNumber(productRequest.getPartNumber())) {
            throw new DuplicatePartNumberException(
                    "Product already exists with partNumber: " + productRequest.getPartNumber()
            );
        }

        // Normalize name to lowercase (business rule)
        productRequest.setPartName(productRequest.getPartName().toLowerCase());

        // Map request → entity
        Product product = productMapper.mapToProduct(productRequest);

        productRepository.save(product);

        return productMapper.mapToProductResponse(product);
    }

    // 2) List all products
    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapToProductResponse(products);
    }

    // 3) Search by name
    @Override
    public List<ProductResponse> searchProducts(String keyword) {
        List<Product> products = productRepository.findByPartNameContainingIgnoreCase(keyword);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found for search keyword: " + keyword);
        }

        return productMapper.mapToProductResponse(products);
    }

    // 4) Filter by category
    @Override
    public List<ProductResponse> filterByCategory(String category) {
        List<Product> products = productRepository.findByCategoryIgnoreCase(category);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found in category: " + category);
        }

        return productMapper.mapToProductResponse(products);
    }

    // 5) Sort products by price ascending
    @Override
    public List<ProductResponse> sortByPriceAsc() {
        List<Product> products = productRepository.findAll(Sort.by("price").ascending());
        return productMapper.mapToProductResponse(products);
    }

    // 6) Total inventory value
    @Override
    public double getTotalInventoryValue() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getStock())
                .sum();
    }
}
