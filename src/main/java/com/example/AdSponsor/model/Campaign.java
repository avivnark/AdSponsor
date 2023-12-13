package com.example.AdSponsor.model;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;


public class Campaign {
    private String name;
    private LocalDate startDate;
    private List<String> ids;
    private double bid;
    private String id;

    public Campaign() {
    }

    public Campaign(String name, LocalDate startDate, List<String> ids, double bid, String id) {
        this.name = name;
        this.startDate = startDate;
        this.ids = ids;
        this.bid = bid;
        this.id = id;
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

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(10);
        // Check if the current date falls between the start and end dates of the campaign
        return currentDate.isAfter(startDate) && currentDate.isBefore(endDate);
    }

}
