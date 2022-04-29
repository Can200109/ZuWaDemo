package com.example.zuwademo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OrderType {
    @Id
    private String orderId;
    private String rentPhone;
    private String type;
    private String productPhone;
    private String productId;
}
