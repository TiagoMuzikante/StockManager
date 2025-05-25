package com.lostdev.StockManager.domain.stock;


import com.lostdev.StockManager.domain.utils.ProductItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ElementCollection
  private List<ProductItem> productItems;

}
