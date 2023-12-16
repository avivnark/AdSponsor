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
    private String serial_number;

    public Product() {
        // Default constructor
    }

    public Product(String title, String category, BigDecimal price, String serial_number) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.serial_number = serial_number;
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

    // Getter method to retrieve the value of serial_number
    public String getSerialNumber() {
        return serial_number;
    }

    // Setter method to set the value of serial_number
    public void setSerialNumber(String newSerialNumber) {
        this.serial_number = newSerialNumber;
    }
}

