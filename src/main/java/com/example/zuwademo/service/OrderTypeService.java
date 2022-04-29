package com.example.zuwademo.service;

import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.entity.OrderType;
import com.example.zuwademo.repository.CollectRepository;
import com.example.zuwademo.repository.OrderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderTypeService {
    @Autowired
    private OrderTypeRepository orderTypeRepository;


    public OrderType addOrderType(OrderType orderType) {
        if(find(orderType.getRentPhone(),orderType.getProductPhone())==null){
            orderType.setOrderId(UUID.randomUUID().toString());
        }
        return orderTypeRepository.save(orderType);
    }

    public void delete(OrderType orderType) {
        orderType = find(orderType.getRentPhone(),orderType.getProductPhone());
        orderTypeRepository.delete(orderType);
    }
    public OrderType findOrderTypeByRentPhoneAndType(String rentPhone,String type){
        return orderTypeRepository.findOrderTypeByRentPhoneAndProductPhone(rentPhone, type);
    }
    public OrderType find(String rentPhone,String productPhone){
        return orderTypeRepository.findOrderTypeByRentPhoneAndProductPhone(rentPhone, productPhone);
    }


}
