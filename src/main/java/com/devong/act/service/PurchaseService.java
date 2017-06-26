package com.devong.act.service;

import com.devong.act.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<String> getPurchases(String branchId);

    Purchase putPurchase(String branchId, String purchaseId);

    void deletePurchase(String branchId, String purchaseId);
}
