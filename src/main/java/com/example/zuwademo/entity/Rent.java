package com.example.zuwademo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Rent {
    @Id
    private String rentId;//自动生成
    private String rentName;
    private String rentDescribe;
    private Double rentPrice;
    private String rentPhoto;
    private String rentType;
    @NotEmpty(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    private String phoneNumber;//外键
    private String productId;//外键
}
