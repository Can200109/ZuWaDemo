package com.example.zuwademo.controller;
8498
import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Product;
import com.example.zuwademo.service.ProductService;
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
@RequestMapping("/product")
@Transactional
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAllProducts")
    public Result<List<Product>> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        return ResultUtil.success(products);
    }

    @PostMapping("/findProductByPhoneNumber")
    public Result<Product> findProductByPhoneNumber(@Valid Product product) {
        return ResultUtil.success(productService.findProductByPhoneNumber(product));
    }

    @PostMapping("/addProduct")
    public Result<Product> addProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        product = productService.addProduct(product);
        return ResultUtil.success(product);
    }

    @PostMapping("/editProduct")
    public Result<Product> editProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        product = productService.addProduct(product);
        return ResultUtil.success(product);
    }

    @PostMapping("/deleteProductByPhoneNumber")
    public Result<Product> deleteProductByPhoneNumber(Product product) {
        product = productService.deleteProductByPhoneNumber(product);
        return ResultUtil.success(product);
    }
    @PostMapping("/deleteProduct")
    public Result<Product> deleteProduct(Product product){
        product = productService.deleteProduct(product);
        return ResultUtil.success(product);
    }
}
