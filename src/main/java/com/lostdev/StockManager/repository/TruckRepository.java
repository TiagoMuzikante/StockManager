package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}
