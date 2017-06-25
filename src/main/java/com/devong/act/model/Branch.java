package com.devong.act.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {
    //국가코드 2자리, number 4자리
    @Id
    private String id;

    @ElementCollection(targetClass = String.class)
    private List<String> products;

    @ElementCollection(targetClass = String.class)
    private List<String> purchases;

    public Branch(){

    }

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
