package com.example.zuwademo.repository;

import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepository extends JpaRepository<OrderType,String> {
    OrderType findOrderTypeByRentPhoneAndType(String rentPhone,String type);
    OrderType findOrderTypeByRentPhoneAndProductPhone(String rentPhone,String productPhone);
}
