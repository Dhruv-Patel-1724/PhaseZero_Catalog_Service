package com.org.phasezero_catalog_service.Repository;


import com.org.phasezero_catalog_service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByPartNumber(String partNumber);

    List<Product> findByPartNameContainingIgnoreCase(String partName);

    List<Product> findByCategoryIgnoreCase(String category);
}
