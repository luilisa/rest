package com.example.rest.repository;

import com.example.rest.entity.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Page<Portfolio> findByUserEntityId(Long userId, Pageable pageable);
    Optional<Portfolio> findByIdAndUserEntityId(Long id, Long userId);
}
