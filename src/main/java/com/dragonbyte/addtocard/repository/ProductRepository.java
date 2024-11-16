package com.dragonbyte.addtocard.repository;

import com.dragonbyte.addtocard.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findByCategoryName(String name);

    List<Product> findByBrand(String name);

    List<Product> findByCategoryNameAndBrand(String categoryName, String brandName);

    List<Product> findByNameAndBrand(String name, String brandName);

    Long countByNameAndBrand(String name, String brandName);
}
