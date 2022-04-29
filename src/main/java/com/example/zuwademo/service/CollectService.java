package com.example.zuwademo.service;

import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.entity.User;
import com.example.zuwademo.repository.CollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CollectService {
    @Autowired
    private CollectRepository collectRepository;


    public Collect addCollect(Collect collect) {
        if(findCollect(collect.getProductId(),collect.getPhoneNumber())==null){
            collect.setCollectId(UUID.randomUUID().toString());
        }
        return collectRepository.save(collect);
    }

    public void delete(Collect collect) {
        collect = findCollect(collect.getProductId(),collect.getPhoneNumber());
       collectRepository.delete(collect);
    }
    public Collect findCollect(String productId,String phoneNumber){
        return collectRepository.findCollectByProductIdAndPhoneNumber(productId, phoneNumber);
    }

}
