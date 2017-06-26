package com.devong.act.controller;

import com.devong.act.model.Product;
import com.devong.act.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="product", description="about product API")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    ProductService productService;

    @ApiOperation(value="Get branch's product list")
    @GetMapping("/branch/{branchId}/products")
    public List<String> getProducts(@PathVariable String branchId){
        return productService.getProducts(branchId);
    }

    @ApiOperation(value="Save branch's product")
    @PutMapping("/branch/{branchId}/product/{productId}")
    public Product putProduct(@PathVariable String branchId, @PathVariable String productId) throws Exception{
        return productService.putProduct(branchId, productId);
    }

    @ApiOperation(value="Delete branch's product")
    @DeleteMapping("/branch/{branchId}/product/{productId}")
    public void deleteProduct(@PathVariable String branchId, @PathVariable String productId) throws Exception{
        productService.deleteProduct(branchId, productId);
    }

}
