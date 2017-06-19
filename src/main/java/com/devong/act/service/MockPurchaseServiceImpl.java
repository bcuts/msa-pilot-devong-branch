package com.devong.act.service;

import com.devong.act.model.MockData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mockPurchaseService")
public class MockPurchaseServiceImpl implements PurchaseService{
    @Override
    public List<String> getPurchases(String branchId) {
        return MockData.getPurchases(branchId);
    }

    @Override
    public int putPurchase(String branchId, String purchaseId) {
        MockData.putPurchase(branchId, purchaseId);
        return 0;
    }

    @Override
    public int deletePurchase(String branchId, String purchaseId) {
        MockData.deltePurcahse(branchId, purchaseId);
        return 0;
    }
}
