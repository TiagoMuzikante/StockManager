package com.lostdev.StockManager.dtos.product;

import com.lostdev.StockManager.dtos.supplier.SupplierBasicDTO;
import com.lostdev.StockManager.enums.product.FormType;
import com.lostdev.StockManager.enums.product.HoseAdapterPoint;
import com.lostdev.StockManager.enums.product.ScrewNutsFlange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductNoReferenceDTO {

  private Long id;
  private String name;
  private String brand;
  private String  form_type;
  private String mold;
  private String type;
  private Integer width_cm;
  private Integer length_cm;
  private Integer inner_diameter;
  private Integer outer_diameter;
  private String depth;
  private HoseAdapterPoint point;
  private Integer jic_mm;
  private Integer opened_depth;
  private Integer closed_depth;
  private Integer average_delivery_time_days;
  private ScrewNutsFlange flange;
  private String material;
  private String hardness;
  private String address;
  private Boolean no_address;
  private Integer availableAmount;
  private Integer reservedAmount;
  private Integer pendingAmount;
  private Integer minimumAmount;
  private Integer price_in_cents;
  private Double price_variation_percent;

  private SupplierBasicDTO supplier;

}
