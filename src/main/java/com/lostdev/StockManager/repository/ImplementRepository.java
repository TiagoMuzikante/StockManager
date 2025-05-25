package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.Implement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImplementRepository extends JpaRepository<Implement, Long> {
}
