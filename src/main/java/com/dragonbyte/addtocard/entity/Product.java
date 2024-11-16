package com.dragonbyte.addtocard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int inventory;
    private BigDecimal price;
    private String brand;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Image> images;

    public Product(String name, Category category, String description, int inventory, BigDecimal price, String brand) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.inventory = inventory;
        this.price = price;
        this.category = category;
    }
}
