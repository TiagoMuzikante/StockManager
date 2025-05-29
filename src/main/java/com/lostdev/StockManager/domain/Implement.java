package com.lostdev.StockManager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Implement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @ManyToOne
  @JoinColumn(name = "truck_id")
  private Truck truck;

}
