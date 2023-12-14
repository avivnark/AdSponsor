package com.example.AdSponsor.model;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.List;

@Table("CAMPAIGNS")
public class Campaign {

    @Id
    private Integer id;
    private String name;
    private LocalDate startDate;
    private List<Integer> ids;
    private double bid;

    public Campaign() {
    }

    public Campaign(String name, LocalDate startDate, List<Integer> ids, double bid) {
        this.name = name;
        this.startDate = startDate;
        this.ids = ids;
        this.bid = bid;
    }

    public void setId(Integer id) {
        this.id=id;
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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }


    public boolean isActive() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(10);
        // Check if the current date falls between the start and end dates of the campaign
        return currentDate.isAfter(startDate) && currentDate.isBefore(endDate);
    }

}
