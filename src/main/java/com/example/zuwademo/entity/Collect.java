package com.example.zuwademo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Collect {
    @Id
    private String collectId;//自动生成
    private String phoneNumber;//外键
    private String productId;//外键
}
