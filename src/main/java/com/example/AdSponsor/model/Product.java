package com.example.AdSponsor.model;

public class Product {
    private Long id;
    private String title;
    private String category;
    private double price;

    public Product(Long id, String title, String category, double price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

