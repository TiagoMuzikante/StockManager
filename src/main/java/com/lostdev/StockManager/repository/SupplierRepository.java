package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
