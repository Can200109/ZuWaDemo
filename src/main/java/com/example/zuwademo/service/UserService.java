package com.example.zuwademo.service;

import com.example.zuwademo.entity.User;
import com.example.zuwademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }


    /*****************************************************
     * 验证码登录时，
     * 如果数据库中有数据就返回"账户不存在，注册并登录成功。
     * "没数据就返回"登录成功"
     * 安卓前端可根据此实现未注册用户进入先跳转到填写信息页面注册用户直接跳转到首页
     * *************************************************/
    public String login(User user) {
        User user1 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if ( user1== null) {
            user.setUserId(UUID.randomUUID().toString());
            addUser(user);
            return "账户不存在，注册并登录成功。";
        }
        return "登录成功";
    }
}
