package com.devong.act.service;

import com.devong.act.model.MockData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mockProductService")
public class MockProductServiceImpl implements ProductService{

    @Override
    public List<String> getProducts(String branchId) {
        return MockData.getProducts(branchId);
    }

    @Override
    public int putProduct(String branchId, String productId) {
        MockData.putProduct(branchId, productId);
        return 0;
    }

    @Override
    public int deleteProduct(String branchId, String productId) {
        MockData.deleteProduct(branchId, productId);
        return 0;
    }
}
