package com.devong.act.service;

import java.util.List;

public interface PurchaseService {
    List<String> getPurchases(String branchId);

    int putPurchase(String branchId, String purchaseId);

    int deletePurchase(String branchId, String purchaseId);
}
