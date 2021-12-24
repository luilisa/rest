package com.example.rest.controller;


import com.example.rest.entity.Stock;
import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.repository.mini.StockMini;
import com.example.rest.repository.StockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StockController {
    private final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    public List<StockMini> getAllStocks() {
        return stockRepository.findAllStock();
    }


    @GetMapping("/stocks")
    public List<? extends Object> getAllStocks(@RequestParam(required = false) Object expand) {
        if (expand != null)  {
            return stockRepository.findAll();
        }
        return stockRepository.findAllStock();
    }

    @GetMapping("/stocks/lessThan")
    public List<? extends Object> getAllStocksLessThan(@RequestParam(required = false) Object expand, @RequestParam(required = false) Double currentPrice) {
        if (expand != null && currentPrice == null) {
            return stockRepository.findAll();
        } else if (expand == null && currentPrice == null){
            return stockRepository.findAllStock();
        } else if (expand != null && currentPrice != null) {
            return stockRepository.findAllByCurrentPriceIsLessThan(currentPrice);
        } else {
            return stockRepository.findAllStockLessThan(currentPrice);
        }
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Long stockId) throws ResourceNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));
            return ResponseEntity.ok().body(stock);
    }


    @PostMapping("/stocks")
    public Stock createStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable(value = "id") Long stockId,
                                                 @RequestBody Stock stockDetails) throws ResourceNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));

        stock.setDate(stockDetails.getDate());
        stock.setOpenPrice(stockDetails.getOpenPrice());
        stock.setClosePrice(stockDetails.getClosePrice());
        stock.setHighPrice(stockDetails.getHighPrice());
        stock.setLowPrice(stockDetails.getLowPrice());
        stock.setCurrentPrice(stockDetails.getCurrentPrice());
        stock.setCompany(stockDetails.getCompany());
        stock.setVolume(stockDetails.getVolume());
        final Stock updatedStock = stockRepository.save(stock);
        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/stocks/{id}")
    public Map<String, Boolean> deleteStock(@PathVariable(value = "id") Long stockId)
            throws ResourceNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));

        stockRepository.delete(stock);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
