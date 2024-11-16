package com.dragonbyte.addtocard.repository;

import com.dragonbyte.addtocard.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String categoryName);
}
