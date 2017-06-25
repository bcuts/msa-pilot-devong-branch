package com.devong.act.repository;

import com.devong.act.model.Branch;

import java.util.*;

public class MockData {
    public static List<String> branchIds;
    private static final Map<String, Branch> branchList;

    static{
        branchIds = new ArrayList<>();
        branchIds.add("KS0001");
        branchIds.add("KS0002");
        branchIds.add("KS0003");
        branchList = new HashMap<>();
        for(String id : branchIds){
            branchList.put(id, new Branch(id));
        }
    }

    public static List<Branch> getBranches() {
        return new ArrayList<>(branchList.values());
    }

    public static List<String> getBranchIds() {
        return branchIds;
    }

    public static Branch getBranch(String id) {
        return branchList.get(id);
    }

    public static Branch putBranch(String branchId) {
        branchIds.add(branchId);
        Branch branch = new Branch(branchId);
        branchList.put(branchId, branch);
        return branch;
    }

    public static List<String> getProducts(String branchId) {
        return branchList.get(branchId).getProducts();
    }

    public static void putProduct(String branchId, String productId) {
        branchList.get(branchId).getProducts().add(productId);
    }

    public static void deleteProduct(String branchId, String productId) {
        branchList.get(branchId).getProducts().remove(productId);
    }

    public static List<String> getPurchases(String branchId) {
        return branchList.get(branchId).getPurchases();
    }

    public static void putPurchase(String branchId, String purchaseId) {
        branchList.get(branchId).getPurchases().add(purchaseId);
    }

    public static void deltePurcahse(String branchId, String purchaseId) {
        branchList.get(branchId).getProducts().remove(purchaseId);
    }
}
