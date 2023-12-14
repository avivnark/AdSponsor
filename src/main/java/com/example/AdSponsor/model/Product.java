package com.example.AdSponsor.model;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Table(name = "PRODUCTS")
public class Product {
    @Id
    private Integer id;
    private String title;
    private String category;
    private BigDecimal price;

    public Product() {
        // Default constructor
    }

    public Product(String title, String category, BigDecimal price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

