package com.example.zuwademo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    @Id
    @NotEmpty(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    private String phoneNumber;
}
