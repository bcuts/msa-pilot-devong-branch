package com.devong.act.controller;

import com.devong.act.model.Purchase;
import com.devong.act.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    @Qualifier("purchaseService")
    PurchaseService purchaseService;

    @GetMapping("/branch/{branchId}/purchases")
    public List<String> getPurchases(@PathVariable String branchId){
        return purchaseService.getPurchases(branchId);
    }

    @PutMapping("/branch/{branchId}/purchase/{purchaseId}")
    public Purchase putPurchase(@PathVariable String branchId, @PathVariable String purchaseId){
        return purchaseService.putPurchase(branchId, purchaseId);
    }

    @DeleteMapping("/branch/{branchId}/purchase/{purchaseId}")
    public void deletePurchase(@PathVariable String branchId, @PathVariable String purchaseId){
        purchaseService.deletePurchase(branchId, purchaseId);
    }

}
