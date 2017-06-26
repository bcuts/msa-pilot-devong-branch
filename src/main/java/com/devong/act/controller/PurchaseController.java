package com.devong.act.controller;

import com.devong.act.model.Purchase;
import com.devong.act.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="purchase", description="about purchase API")
public class PurchaseController {
    @Autowired
    @Qualifier("purchaseService")
    PurchaseService purchaseService;

    @ApiOperation(value="Get branch's purchase list")
    @GetMapping("/branch/{branchId}/purchases")
    public List<String> getPurchases(@PathVariable String branchId){
        return purchaseService.getPurchases(branchId);
    }

    @ApiOperation(value="Save branch's purchase")
    @PutMapping("/branch/{branchId}/purchase/{purchaseId}")
    public Purchase putPurchase(@PathVariable String branchId, @PathVariable String purchaseId){
        return purchaseService.putPurchase(branchId, purchaseId);
    }

    @ApiOperation(value="Delete branch's purchase")
    @DeleteMapping("/branch/{branchId}/purchase/{purchaseId}")
    public void deletePurchase(@PathVariable String branchId, @PathVariable String purchaseId){
        purchaseService.deletePurchase(branchId, purchaseId);
    }

}
