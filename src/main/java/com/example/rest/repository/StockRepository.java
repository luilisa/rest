package com.example.rest.repository;

import com.example.rest.entity.Stock;
import com.example.rest.repository.mini.StockMini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query(value = "SELECT stock.id as id, stock.symbol as symbol, stock.current_price as currentPrice from stock", nativeQuery = true)
    List<StockMini> findAllStock();
    @Query(value = "SELECT stock.id as id, stock.symbol as symbol, stock.current_price as currentPrice from stock where current_price < :price", nativeQuery = true)
    List<StockMini> findAllStockLessThan(@Param (value = "price") Double price);
    List<Stock> findAllByCurrentPriceIsLessThan(Double price);
}
