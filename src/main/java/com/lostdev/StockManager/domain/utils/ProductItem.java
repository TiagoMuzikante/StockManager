package com.lostdev.StockManager.domain.utils;

import com.lostdev.StockManager.domain.stock.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductItem {

  private Long productId;
  private Integer amount;

  @Transient
  private Product product;

}
