package com.example.AdSponsor.model;
import java.time.LocalDate;
import java.util.List;

public class Campaign {
    private String name;
    private LocalDate startDate;
    private List<Long> ids;
    private double bid;
    private Long id;

    public Campaign(String name, LocalDate startDate, List<Long> ids, double bid, long id) {
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(10);
        // Check if the current date falls between the start and end dates of the campaign
        return currentDate.isAfter(startDate) && currentDate.isBefore(endDate);
    }

}
