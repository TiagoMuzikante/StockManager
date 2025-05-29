package com.lostdev.StockManager.domain.stock;

import com.lostdev.StockManager.domain.Implement;
import com.lostdev.StockManager.domain.Truck;
import com.lostdev.StockManager.enums.buy.Reason;
import com.lostdev.StockManager.enums.buy.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BuyOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer amount;

  @Enumerated(EnumType.STRING)
  private Reason reason;

  @Enumerated(EnumType.STRING)
  private Status status;

  @OneToOne
  @JoinColumn(name = "implement_id")
  private Implement implement;

  @OneToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "truck_id")
  private Truck truck;

  public BuyOrder(Integer amount, Reason reason, Product product) {
    this.amount = amount;
    this.reason = reason;
    this.product = product;
    this.status = Status.PENDENTE_DE_COMPRA;
  }

  public BuyOrder(Integer amount, Reason reason, Implement implement, Product product, Truck truck) {
    this.amount = amount;
    this.reason = reason;
    this.implement = implement;
    this.product = product;
    this.truck = truck;
    this.status = Status.PENDENTE_DE_COMPRA;
  }
}
