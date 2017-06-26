package com.devong.act.repository;

import com.devong.act.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select productId from Product where branchId=:branchId")
    List<String> getAllProductsInBranch(@Param("branchId") String branchId);

    @Query("select count(*) from Product where branchId=:branchId and productId=:productId")
    int countProductInBranch(@Param("branchId") String branchId, @Param("productId") String productId);
}
