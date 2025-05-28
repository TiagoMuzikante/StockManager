package com.lostdev.StockManager.dtos.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierBasicDTO {

  private Long id;
  private String name;
  private String contact;

}
