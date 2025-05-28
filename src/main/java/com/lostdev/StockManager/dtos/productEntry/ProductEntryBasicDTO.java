package com.lostdev.StockManager.dtos.productEntry;

import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntryBasicDTO {

  private Long id;
  private Integer amount;
  private ProductBasicDTO product;

}
