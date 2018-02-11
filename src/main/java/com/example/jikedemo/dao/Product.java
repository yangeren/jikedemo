package com.example.jikedemo.dao;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{

    private static final long serialVersionUID = 748392348L;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {

    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
