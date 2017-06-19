package com.devong.act.model;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    //국가코드 2자리, number 4자리
    private String id;
    private List<String> products;
    private List<String> purchases;

    public Branch(String id) {
        this.id = id;
        products = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public void setPurchases(List<String> purchases){
        this.purchases = purchases;
    }

    public void setProducts(List<String> products){
        this.products = products;
    }

    public List<String> getPurchases(){
        return purchases;
    }

    public List<String> getProducts(){
        return products;
    }
}
