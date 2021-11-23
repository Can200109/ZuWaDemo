package com.example.zuwademo.controller;

import com.example.zuwademo.auth.CheckLogin;
import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.User;
import com.example.zuwademo.service.UserService;
import com.example.zuwademo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Transactional
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user) {
        String token = userService.login(user);
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return token;
    }

    @PostMapping("/addUser")
    //@Valid数据验证

    public Result<User> addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        user = userService.addUser(user);
        return ResultUtil.success(user);
    }

    @PostMapping("/editUser")
    @CheckLogin
    public Result<User> modifyUser(@Valid User user, BindingResult bindingResult) {//根据手机号进行修改，先查找出来再保存。安卓页面实现点击修改按钮显示用户的信息
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        user = userService.addUser(user);
        return ResultUtil.success(user);
    }

    @PostMapping("/deleteUser")
    //删除操作只传入电话号码即可
    public Result<User> delete(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(userService.delete(user));
    }

    @PostMapping("/findUserByPhoneNumber")
    public Result<User> findUserByPhoneNumber(@RequestParam String phoneNumber) {
        return ResultUtil.success(userService.findUserByPhoneNumber(phoneNumber));
    }

}
