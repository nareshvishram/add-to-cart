package com.dragonbyte.addtocard.service.product;

import com.dragonbyte.addtocard.dto.ProductDTO;
import com.dragonbyte.addtocard.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product addProduct(ProductDTO product);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProductById(Long id);
    Product getProductById(Long id);
    Product getProductByName(String name);
    List<Product> getProductsByCategoryName(String name);
    List<Product> getProductsByBrandName(String name);
    List<Product> getProductsByCategoryAndBrandName(String categoryName, String brandName);
    List<Product> getProductsByNameAndBrandName(String name, String brandName);
    Long countProductsByNameAndBrandName(String name,String brandName);
}
