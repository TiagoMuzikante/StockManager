package com.lostdev.StockManager.DTOs.productEntry;

import com.lostdev.StockManager.DTOs.product.ProductBasicDTO;
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
