package com.example.zuwademo.controller;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.service.CollectService;
import com.example.zuwademo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collect")
@Transactional
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("/addCollect")
    private Result<Collect> addCollect(Collect collect){
        return ResultUtil.success(collectService.addCollect(collect));
    }
    @RequestMapping("/findCollect")
    private Result<Collect> findCollect(Collect collect){
        return ResultUtil.success(collectService.findCollect(collect.getProductId(),collect.getPhoneNumber()));
    }
    @RequestMapping("/deleteCollect")
    private void deleteCollect(Collect collect){
        collectService.delete(collect);
    }
}
