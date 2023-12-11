package com.example.AdSponsor;

public class Product {
    private String productSerialNumber;
    private String title;
    private String category;
    private double price;

    public Product(String productSerialNumber, String title, String category, double price) {
        this.productSerialNumber = productSerialNumber;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
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

