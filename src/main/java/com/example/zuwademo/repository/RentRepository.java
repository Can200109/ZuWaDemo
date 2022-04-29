package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, String> {
    Rent deleteByPhoneNumber(String phoneNumber);

    Rent findByPhoneNumber(String phoneNumber);
    Rent findByRentId(String rentId);
}
