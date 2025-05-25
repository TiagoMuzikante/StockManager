package com.lostdev.StockManager.DTOs.productOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutPostDTO {

  private Integer amount;
  private Long productId;

}
