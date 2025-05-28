package com.lostdev.StockManager.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostDTO {

  private String name;
  private String address;
  private Boolean noAddress;
  private String brand;
  private Integer minimumAmount;

  private Long supplierId;

}
