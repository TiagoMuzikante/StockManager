package com.lostdev.StockManager.domain.stock;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String address;
  private Boolean noAddress;
  private String brand;
  private Integer amount = 0;
  private Integer minimunAmount = 0;
  private Integer itensPerPackage = 0;

  @OneToMany(mappedBy = "product")
  private List<ProductEntry> productEntries;
  @OneToMany(mappedBy = "product")
  private List<ProductOut> productOuts;

}
