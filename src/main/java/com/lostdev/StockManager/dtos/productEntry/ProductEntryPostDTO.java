package com.lostdev.StockManager.dtos.productEntry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntryPostDTO {

  private Integer amount;
  private Long productId;

}
