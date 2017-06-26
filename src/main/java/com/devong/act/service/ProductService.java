package com.devong.act.service;

import com.devong.act.model.Product;

import java.util.List;

public interface ProductService {
    List<String> getProducts(String branchId);

    Product putProduct(String branchId, String productId) throws Exception;

    void deleteProduct(String branchId, String productId);
}
