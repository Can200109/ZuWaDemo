package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectRepository extends JpaRepository<Collect,String> {
    Collect findCollectByProductIdAndPhoneNumber(String productId,String phoneNumber);
    List<Collect> findCollectsByPhoneNumber(String phoneNumber);
}
