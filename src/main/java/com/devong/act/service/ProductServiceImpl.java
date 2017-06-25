package com.devong.act.service;

import com.devong.act.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productDao;

    @Override
    public List<String> getProducts(String branchId) {

        return null;
    }

    @Override
    public int putProduct(String branchId, String productId) {
        return 0;
    }

    @Override
    public int deleteProduct(String branchId, String productId) {
        return 0;
    }
}
