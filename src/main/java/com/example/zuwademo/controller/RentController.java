package com.example.zuwademo.controller;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Rent;
import com.example.zuwademo.service.RentService;
import com.example.zuwademo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rent")
@Transactional
public class RentController {
    @Autowired
    private RentService rentService;

    @GetMapping("/findAllRents")
    public Result<List<Rent>> findAllRents() {
        List<Rent> rents = rentService.findAllRents();
        return ResultUtil.success(rents);
    }

    @PostMapping("/findRentByPhoneNumber")
    public Result<Rent> findRentByPhoneNumber(@Valid Rent rent) {
        return ResultUtil.success(rentService.findRentByPhoneNumber(rent));
    }

    @PostMapping("/addRent")
    public Result<Rent> addRent(@Valid Rent rent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        rent = rentService.addRent(rent);
        return ResultUtil.success(rent);
    }

    @PostMapping("/editRent")
    public Result<Rent> editRent(@Valid Rent rent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        rent = rentService.addRent(rent);
        return ResultUtil.success(rent);
    }

    @PostMapping("/deleteRentByPhoneNumber")
    public Result<Rent> deleteRentByPhoneNumber(Rent rent) {
        rent = rentService.deleteRentByPhoneNumber(rent);
        return ResultUtil.success(rent);
    }
}
