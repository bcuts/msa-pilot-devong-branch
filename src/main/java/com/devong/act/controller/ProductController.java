package com.devong.act.controller;

import com.devong.act.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("mockProductService")
    ProductService productService;

    @GetMapping("/branch/{branchId}/products")
    public List<String> getProducts(@PathVariable String branchId){
        return productService.getProducts(branchId);
    }

    @PutMapping("/branch/{branchId}/product/{productId}")
    public int putProduct(@PathVariable String branchId, @PathVariable String productId){
        return productService.putProduct(branchId, productId);
    }

    @DeleteMapping("/branch/{branchId}/product/{productId}")
    public int deleteProduct(@PathVariable String branchId, @PathVariable String productId){
        return productService.deleteProduct(branchId, productId);
    }

}
