package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
