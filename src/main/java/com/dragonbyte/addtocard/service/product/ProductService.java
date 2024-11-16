package com.dragonbyte.addtocard.service.product;

import com.dragonbyte.addtocard.dto.ProductDTO;
import com.dragonbyte.addtocard.entity.Category;
import com.dragonbyte.addtocard.exceptions.CategoryNotFoundException;
import com.dragonbyte.addtocard.exceptions.ProductNotFoundException;
import com.dragonbyte.addtocard.entity.Product;
import com.dragonbyte.addtocard.repository.CategoryRepository;
import com.dragonbyte.addtocard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product addProduct(ProductDTO product) {
        Category category=Optional.ofNullable(categoryRepository.findByName(product.getCategory().getName()))
                .orElseGet(
                        () -> {
                            Category newCategory= new Category(product.getCategory().getName());
                            return categoryRepository.save(newCategory);
                        }
                );
        return createProduct(product,category);
    }

    private Product createProduct(ProductDTO product, Category category) {
        Product newProduct=new Product(
                product.getName(),
                category,
                product.getDescription(),
                product.getInventory(),
                product.getPrice(),
                product.getBrand()
        );
        return productRepository.save(newProduct);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete,
                () -> {throw new CategoryNotFoundException("Category Not Found!!");
                });
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("No Product Found"));
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByCategoryName(String name) {
        return productRepository.findByCategoryName(name);
    }

    @Override
    public List<Product> getProductsByBrandName(String name) {
        return productRepository.findByBrand(name);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrandName(String categoryName, String brandName) {
        return productRepository.findByCategoryNameAndBrand(categoryName,brandName);
    }

    @Override
    public List<Product> getProductsByNameAndBrandName(String name, String brandName) {
        return productRepository.findByNameAndBrand(name,brandName);
    }

    @Override
    public Long countProductsByNameAndBrandName(String name, String brandName) {
        return productRepository.countByNameAndBrand(name,brandName);
    }
}
