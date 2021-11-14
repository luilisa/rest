package com.example.rest.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    private long id;
    private double profitability;
    private Timestamp creationDate;
    private String name;
    private long stockId;
    private long userId;

    public Portfolio() {
    }

    public Portfolio(double profitability, Timestamp creationDate, String name, long stockId, long userId) {
        this.profitability = profitability;
        this.creationDate = creationDate;
        this.name = name;
        this.stockId = stockId;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "profitability")
    public double getProfitability() {
        return profitability;
    }
    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    @Column(name = "creation_date", nullable = false)
    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "stock_id")
    public long getStockId() {
        return stockId;
    }
    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
