package com.lostdev.StockManager.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasicDTO {

  private Long id;
  private String name;
  private Integer availableAmount;
  private Integer reservedAmount;
  private Integer pendingAmount;
  private Integer minimumAmount;
  private String address;

}
