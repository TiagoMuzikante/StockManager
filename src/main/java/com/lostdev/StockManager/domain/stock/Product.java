package com.lostdev.StockManager.domain.stock;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.enums.product.FormType;
import com.lostdev.StockManager.enums.product.HoseAdapterPoint;
import com.lostdev.StockManager.enums.product.ScrewNutsFlange;
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
  private String brand;
  private FormType formType;
  private String mold;
  private String type;
  private Integer widthCm;
  private Integer lengthCm;
  private Integer innerDiameter;
  private Integer outerDiameter;
  private String depth;
  private HoseAdapterPoint point;
  private Integer jicMm;
  private Integer openedDepth;
  private Integer closedDepth;
  private Integer averageDeliveryTimeDays;
  private ScrewNutsFlange flange;
  private String material;
  private String hardness;
  private String address;
  private Boolean noAddress;
  private Integer availableAmount = 0;
  private Integer reservedAmount = 0;
  private Integer pendingAmount = 0;
  private Integer minimumAmount = 0;
  private Integer priceInCents;
  private Double priceVariationPercent;



  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;
  @OneToMany(mappedBy = "product")
  private List<ProductEntry> productEntries;
  @OneToMany(mappedBy = "product")
  private List<ProductOut> productOuts;



}
