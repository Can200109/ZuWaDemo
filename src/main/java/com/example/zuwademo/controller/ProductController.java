package com.example.zuwademo.controller;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.entity.Product;
import com.example.zuwademo.entity.User;
import com.example.zuwademo.service.ProductService;
import com.example.zuwademo.utils.ResultUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @PostMapping("/findProductByProductType")
    public Result<List<Product>> findProductByProductType(@RequestParam("productType") String productType){
        return ResultUtil.success(productService.findProductByType(productType));
    }
    @PostMapping("/findProductById")
    public Result<Product> findProductById(@RequestParam("productId") String productId){
        return ResultUtil.success(productService.findProductById(productId));
    }
    @PostMapping("/uploadPhoto")
    public Result uploadPhoto(@Valid @RequestParam(value = "file") MultipartFile[] files, Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        product=productService.findProductById(product.getProductId());
        List<String> photos = new ArrayList<>();
        for(MultipartFile file:files){
            if (file.isEmpty()) {
                return ResultUtil.error("文件是空的");
            }else {
                String fileName = file.getOriginalFilename();  // 文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                String filePath = "D://ZuWaData//"+product.getPhoneNumber()+"//"+product.getProductId()+"//"; // 上传后的路径
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
                photos.add(filename);

            }
            Gson gson = new Gson();
            String photosJson = gson.toJson(photos);
            product.setProductPhoto(photosJson);
        }
        return ResultUtil.success("添加成功");
    }
}
