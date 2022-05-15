package com.example.zuwademo.controller;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Collect;
import com.example.zuwademo.entity.OrderType;
import com.example.zuwademo.service.OrderTypeService;
import com.example.zuwademo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderType")
@Transactional
public class OrderTypeController {
    @Autowired
    OrderTypeService orderTypeService;

    @RequestMapping("/addOrder")
    private Result<OrderType> addOrder(OrderType orderType){
        return ResultUtil.success(orderTypeService.addOrderType(orderType));
    }
    @RequestMapping("/findOrder")
    private Result<List<OrderType>> findOrder(OrderType orderType){
        return ResultUtil.success(orderTypeService.findOrderTypeByRentPhoneAndType(orderType.getRentPhone(), orderType.getType()));
    }
    @RequestMapping("/deleteOrder")
    private void deleteOrder(OrderType orderType){
        orderTypeService.delete(orderType);
    }
}
