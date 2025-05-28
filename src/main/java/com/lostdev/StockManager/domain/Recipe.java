package com.lostdev.StockManager.domain;


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

  @OneToOne(mappedBy = "recipe")
  private Implement implement;

  @ElementCollection
  private List<ProductItem> productItems;

}
