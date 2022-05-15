package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, String> {
    Rent deleteByPhoneNumber(String phoneNumber);

    List<Rent> findByPhoneNumber(String phoneNumber);

//    Rent deleteRentByPhoneNumber(String phoneNumber, String productId);
    Rent findByRentId(String rentId);
}
