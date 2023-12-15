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
<<<<<<< HEAD
=======
    private String serial_number;

>>>>>>> 0b7d5b4 (sql)

    public Product() {
        // Default constructor
    }

<<<<<<< HEAD
    public Product(String title, String category, BigDecimal price) {
        this.title = title;
        this.category = category;
        this.price = price;
=======
    public Product(Integer id, String title, String category, BigDecimal price, String serialNumber) {
        this.id=id;
        this.title = title;
        this.category = category;
        this.price = price;
        serial_number = serialNumber;
>>>>>>> 0b7d5b4 (sql)
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
<<<<<<< HEAD
=======

    // Getter method to retrieve the value of serial_number
    public String getSerialNumber() {
        return serial_number;
    }

    // Setter method to set the value of serial_number
    public void setSerialNumber(String newSerialNumber) {
        this.serial_number = newSerialNumber;
    }


>>>>>>> 0b7d5b4 (sql)
}

