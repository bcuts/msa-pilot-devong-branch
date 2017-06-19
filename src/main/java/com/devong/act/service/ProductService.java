package com.devong.act.service;

import java.util.List;

public interface ProductService {
    List<String> getProducts(String branchId);

    int putProduct(String branchId, String productId);

    int deleteProduct(String branchId, String productId);
}
