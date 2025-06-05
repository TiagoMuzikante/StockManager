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
  private Boolean no_address;
  private String brand;
  private String form_type;
  private String mold;
  private String type;
  private Integer width_cm;
  private Integer length_cm;
  private Integer inner_diameter;
  private Integer outer_diameter;
  private String depth;
  private String point;
  private Integer jic_mm;
  private Integer opened_depth;
  private Integer closed_depth;
  private String flange;
  private String material;
  private String hardness;
  private Integer availableAmount;
  private Integer reservedAmount;
  private Integer pendingAmount;
  private Integer minimumAmount;
  private Integer price_in_cents;
  private Double price_variation_percent;

  private String supplier;

}
