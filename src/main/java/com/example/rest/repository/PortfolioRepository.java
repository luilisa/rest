package com.example.rest.repository;

import com.example.rest.entity.Portfolio;
import com.example.rest.repository.mini.PortfolioMini;
import com.example.rest.repository.mini.StockMini;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllByUserEntityId(Long userId);
    @Query(value = "SELECT portfolio.id as id, portfolio.profitability as profitability, portfolio.creation_date as creationDate, portfolio.name as name from portfolio", nativeQuery = true)
    List<PortfolioMini> findAllPortfolio();
    @Query(value = "SELECT portfolio.id as id, portfolio.profitability as profitability, portfolio.creation_date as creationDate, portfolio.name as name from portfolio where user_id= :userId", nativeQuery = true)
    List<PortfolioMini> findAllPortfolioByUserEntityId(@Param (value = "userId") Long userId);
}
