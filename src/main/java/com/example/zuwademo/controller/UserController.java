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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public Result<User> addUser(@Valid  User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        user = userService.addUser(user);
        return ResultUtil.success(user);
    }

    @PostMapping("/editUser")
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
    @PostMapping("/uploadPhoto")
    public Result uploadPhoto( @Valid @RequestParam(value = "file") MultipartFile file,User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        user=userService.findUserByPhoneNumber(user.getPhoneNumber());
        if (file.isEmpty()) {
            return ResultUtil.error("文件是空的");
        }else {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "D://ZuWaData//"+user.getPhoneNumber()+"//"; // 上传后的路径
            fileName = UUID.randomUUID().toString().replace("-", "") + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename =fileName;
            System.out.println(filename);
            user.setUserPhoto(filename);
            userService.addUser(user);
        }
        return ResultUtil.success("添加成功");
    }

}
