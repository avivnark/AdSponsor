package com.example.AdSponsor;
import java.time.LocalDate;
import java.util.List;

public class Campaign {
    private String name;
    private LocalDate startDate;
    private List<String> productIdentifiers;
    private double bid;

    public Campaign(String name, LocalDate startDate, List<String> productIdentifiers, double bid) {
        this.name = name;
        this.startDate = startDate;
        this.productIdentifiers = productIdentifiers;
        this.bid = bid;
    }

    // Getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<String> getProductIdentifiers() {
        return productIdentifiers;
    }

    public void setProductIdentifiers(List<String> productIdentifiers) {
        this.productIdentifiers = productIdentifiers;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
