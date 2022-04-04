package com.example.zuwademo.entity;

import lombok.Data;
import lombok.Generated;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Product {
    @Id
    private String productId;//自动生成
    private String productName;
    private String productDescribe;
    private Double productPrice;
    private String productDeposit;
    private String productPhoto;
    private Integer productCount;/*在安卓客户端形成，每次生成数据从后台查找出来，数据发生变化就提交到后台。*/
    private String productType;
    @NotEmpty(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    private String phoneNumber;
}
