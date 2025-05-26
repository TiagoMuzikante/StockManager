package com.lostdev.StockManager.DTOs.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostDTO {

  private String name;
  private String address;
  private Boolean noAddress;
  private Integer amount;
  private String brand;
  private Integer minimunAmount;
  private Integer itensPerPackage;

}
