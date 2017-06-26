package com.devong.act.service;

import com.devong.act.common.CommonConstants;
import com.devong.act.model.Purchase;
import com.devong.act.repository.BranchRepository;
import com.devong.act.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    BranchRepository branchDao;

    @Autowired
    PurchaseRepository purchaseDao;

    @Override
    public List<String> getPurchases(String branchId) {
        if(branchDao.exists(branchId)) {
            return purchaseDao.getAllPurchasesInBranch(branchId);
        }else{
            throw new EntityNotFoundException(CommonConstants.EXCEPTION_NOT_EXIST_BRANCH);
        }
    }

    @Override
    public Purchase putPurchase(String branchId, String purchaseId) {
        if(branchDao.exists(branchId)) {
            if (purchaseDao.countPurchaseInBranch(branchId, purchaseId) == 0) {
                Purchase purchase = new Purchase();
                purchase.setBranchId(branchId);
                purchase.setPurchaseId(purchaseId);
                return purchaseDao.save(purchase);
            } else {
                throw new EntityExistsException(CommonConstants.EXCEPTION_CONFLICT_PURCHASE);
            }
        }else {
            throw new EntityNotFoundException(CommonConstants.EXCEPTION_NOT_EXIST_BRANCH);
        }
    }

    @Override
    public void deletePurchase(String branchId, String purchaseId) {
        Purchase purchase = new Purchase();
        purchase.setBranchId(branchId);
        purchase.setPurchaseId(purchaseId);
        purchaseDao.delete(purchase);
    }
}
