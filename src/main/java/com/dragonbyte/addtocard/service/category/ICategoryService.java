package com.dragonbyte.addtocard.service.category;

import com.dragonbyte.addtocard.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category updateCategory(Category category,Long id);
    void deleteCategoryById(Long id);
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
}
