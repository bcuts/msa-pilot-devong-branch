package com.devong.act.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch implements Serializable{
    private static final long serialVersionUID = 1L;
    //국가코드 2자리, number 4자리
    @Id
    private String id;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
