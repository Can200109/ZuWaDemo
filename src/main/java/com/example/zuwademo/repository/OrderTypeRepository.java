package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderTypeRepository extends JpaRepository<OrderType,String> {
    List<OrderType> findOrderTypeByRentPhoneAndType(String rentPhone, String type);
    OrderType findOrderTypeByRentPhoneAndProductPhone(String rentPhone,String productPhone);
}
