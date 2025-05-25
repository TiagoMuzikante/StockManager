package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOutRepository extends JpaRepository<ProductOut, Long> {

  List<ProductOut> findByProduct(Product product);

}
