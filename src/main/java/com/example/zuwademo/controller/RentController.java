package com.example.zuwademo.controller;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Rent;
import com.example.zuwademo.service.RentService;
import com.example.zuwademo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public Result<List<Rent>> findRentByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return ResultUtil.success(rentService.findRentByPhoneNumber(phoneNumber));
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

    @PostMapping("/deleteRent")
    public void deleteRent(Rent rent) {
        rentService.deleteRent(rent);
    }
}
