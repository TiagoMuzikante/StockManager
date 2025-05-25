package com.lostdev.StockManager.DTOs.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasicDTO {

  private Long id;
  private String name;
  private Integer amount;
  private String address;

}
