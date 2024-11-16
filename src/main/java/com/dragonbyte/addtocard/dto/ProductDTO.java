package com.dragonbyte.addtocard.dto;

import com.dragonbyte.addtocard.entity.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int inventory;
    private BigDecimal price;
    private String brand;
    private Category category;
}
