package com.lostdev.StockManager.domain.stock;

import com.lostdev.StockManager.domain.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String address;
  private Boolean noAddress;
  private String brand;
  private Integer availableAmount = 0;
  private Integer reservedAmount = 0;
  private Integer pendingAmount = 0;
  private Integer minimumAmount = 0;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;
  @OneToMany(mappedBy = "product")
  private List<ProductEntry> productEntries;
  @OneToMany(mappedBy = "product")
  private List<ProductOut> productOuts;



}
