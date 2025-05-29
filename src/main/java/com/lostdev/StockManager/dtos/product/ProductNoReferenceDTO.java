package com.lostdev.StockManager.dtos.product;

import com.lostdev.StockManager.dtos.supplier.SupplierBasicDTO;
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
  private String address;
  private Boolean noAddress;
  private String brand;
  private Integer availableAmount = 0;
  private Integer reservedAmount = 0;
  private Integer pendingAmount = 0;
  private Integer minimumAmount = 0;

  private SupplierBasicDTO supplier;

}
