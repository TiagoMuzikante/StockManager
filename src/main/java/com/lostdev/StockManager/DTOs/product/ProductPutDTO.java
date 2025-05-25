package com.lostdev.StockManager.DTOs.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
  private LocalDate validate;
  private Boolean noValidate;

}
