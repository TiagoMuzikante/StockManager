package com.lostdev.StockManager.dtos.productOut;

import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
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
