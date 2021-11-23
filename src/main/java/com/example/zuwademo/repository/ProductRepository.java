package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    void deleteByPhoneNumber(String phoneNumber);

    Product findProductByPhoneNumber(String phoneNumber);
}
