package com.lostdev.StockManager.domain;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Truck {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String plate;
  private String color;
  private String chassisNumber;

  @OneToMany(mappedBy = "truck")
  private List<BuyOrder> buyOrders;

  @OneToMany(mappedBy = "truck")
  private List<Implement> implementList;

}
