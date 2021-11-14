package com.example.rest.entity;

import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stock")
public class Stock {

    private long id;
    private Timestamp date;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
    private double currentPrice;
    private long companyId;
    private int volume;

    public Stock(Timestamp date, double openPrice, double closePrice, double highPrice, double lowPrice, double currentPrice, long companyId, int volume) {
        this.date = date;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.currentPrice = currentPrice;
        this.companyId = companyId;
        this.volume = volume;
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

    @Column(name = "date", nullable = false)
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

    @Column(name = "company_id")
    public long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Column(name = "volume", nullable = false)
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
