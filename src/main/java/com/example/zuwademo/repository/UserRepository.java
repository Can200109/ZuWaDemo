package com.example.zuwademo.repository;

import com.example.zuwademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String phoneNumber);
}
