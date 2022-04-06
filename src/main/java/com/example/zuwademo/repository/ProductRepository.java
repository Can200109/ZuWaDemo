package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    void deleteByPhoneNumber(String phoneNumber);

    Product findProductByPhoneNumber(String phoneNumber);
    List<Product> findProductByProductType(String productType);
    Product findProductByProductId(String productId);
}
