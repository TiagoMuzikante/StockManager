package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductEntryRepository extends JpaRepository<ProductEntry, Long> {

  List<ProductEntry> findByProduct(Product product);
  
}
