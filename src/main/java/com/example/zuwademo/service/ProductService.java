package com.example.zuwademo.service;

import com.example.zuwademo.entity.Product;
import com.example.zuwademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if (product.getProductId() == null || "".equals(product.getProductId())) {
            product.setProductId(UUID.randomUUID().toString());
        }
        return productRepository.save(product);

    }

    public Product deleteProductByPhoneNumber(Product product) {
        productRepository.deleteByPhoneNumber(product.getPhoneNumber());
        return product;
    }

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findProductByPhoneNumber(Product product) {
        return productRepository.findProductByPhoneNumber(product.getPhoneNumber());
    }
    public Product deleteProduct(Product product){
        productRepository.deleteById(product.getProductId());
        return product;
    }
}
