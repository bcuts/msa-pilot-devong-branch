package com.devong.act.repository;

import com.devong.act.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, String>{

    @Query("select purchaseId from Purchase where branchId=:branchId")
    List<String> getAllPurchasesInBranch(@Param("branchId") String branchId);

    @Query("select count(*) from Purchase where branchId=:branchId and purchaseId=:purchaseId")
    int countPurchaseInBranch(@Param("branchId") String branchId, @Param("purchaseId") String purchaseId);

}
