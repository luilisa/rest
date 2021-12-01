package com.example.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    private long id;
    private Timestamp date;
    private String symbol;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
    private double currentPrice;
    private Company company;
    private int volume;
    private List<Portfolio> portfolios;

    public Stock(Timestamp date, String symbol, double openPrice, double closePrice, double highPrice, double lowPrice, double currentPrice, Company company, int volume, List<Portfolio> portfolios) {
        this.date = date;
        this.symbol = symbol;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.currentPrice = currentPrice;
        this.company = company;
        this.volume = volume;
        this.portfolios = portfolios;
    }

    public Stock() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "open_price", nullable = false)
    public double getOpenPrice() {
        return openPrice;
    }
    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    @Column(name = "close_price", nullable = false)
    public double getClosePrice() {
        return closePrice;
    }
    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    @Column(name = "high_price", nullable = false)
    public double getHighPrice() {
        return highPrice;
    }
    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    @Column(name = "low_price", nullable = false)
    public double getLowPrice() {
        return lowPrice;
    }
    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    @Column(name = "current_price", nullable = false)
    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @OneToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    @Column(name = "volume", nullable = false)
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "stocks")
    public List<Portfolio> getPortfolios() {
        return portfolios;
    }
    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    @Column(name = "symbol", nullable = false)
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
