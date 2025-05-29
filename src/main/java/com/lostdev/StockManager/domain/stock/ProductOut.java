package com.lostdev.StockManager.domain.stock;

import com.lostdev.StockManager.domain.Recipe;
import com.lostdev.StockManager.domain.listener.ProductOutListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(ProductOutListener.class)
public class ProductOut {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int amount;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

}
