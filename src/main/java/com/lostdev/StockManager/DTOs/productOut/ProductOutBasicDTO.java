package com.lostdev.StockManager.DTOs.productOut;

import com.lostdev.StockManager.DTOs.product.ProductBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutBasicDTO {

  private Long id;
  private Integer amount;
  private ProductBasicDTO product;
}
