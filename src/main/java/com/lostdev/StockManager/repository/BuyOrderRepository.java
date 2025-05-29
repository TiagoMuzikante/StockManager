package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyOrderRepository extends JpaRepository<BuyOrder, Long> {
}
