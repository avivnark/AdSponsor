package com.example.AdSponsor.model;
<<<<<<< HEAD
=======
import org.springframework.data.annotation.Transient;
>>>>>>> 0b7d5b4 (sql)
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table("CAMPAIGNS")
public class Campaign {

    @Id
    private Integer id;
    private String name;
    private LocalDate startDate;
<<<<<<< HEAD
=======
    @Transient
>>>>>>> 0b7d5b4 (sql)
    private List<Integer> ids;
    private BigDecimal bid;

    public Campaign() {
    }

    public Campaign(String name, LocalDate startDate, List<Integer> ids, BigDecimal bid) {
        this.name = name;
        this.startDate = startDate;
        this.ids = ids;
        this.bid = bid;
    }

<<<<<<< HEAD
=======


>>>>>>> 0b7d5b4 (sql)
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

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
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
