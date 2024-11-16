package com.dragonbyte.addtocard.service.category;

import com.dragonbyte.addtocard.entity.Category;
import com.dragonbyte.addtocard.exceptions.CategoryNotFoundException;
import com.dragonbyte.addtocard.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category,Long id) {
        return Optional.ofNullable(getCategoryById(id)).map((old) -> {
            old.setName(category.getName());
            return categoryRepository.save(old);
        }).orElseThrow(() -> new CategoryNotFoundException("Category Not Found!!"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete,() -> {
            throw new CategoryNotFoundException("No Category Found!!");
        });
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("No Category Found!!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
