package com.lostdev.StockManager.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPutDTO {

  private Long id;
  private String name;
  private String address;
  private Boolean noAddress;
  private String brand;
  private Integer amount;
  private Integer minimunAmount;
  private Integer itensPerPackage;

}
