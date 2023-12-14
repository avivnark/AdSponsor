package com.example.AdSponsor.model;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Table(name = "PRODUCTS")
public class Product {
    @Id
    private Integer id;
    private String title;
    private String category;
    private double price;

    public Product() {
        // Default constructor
    }

    public Product(String title, String category, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

