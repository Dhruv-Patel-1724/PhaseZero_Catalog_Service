package com.org.phasezero_catalog_service.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String partNumber;

    private String partName;

    private String category;

    private double price;

    private int stock;

}
