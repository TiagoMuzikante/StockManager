package com.lostdev.StockManager.dtos.Implement;

import com.lostdev.StockManager.dtos.recipe.RecipePostDTO;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImplementPostDTO {

  private String name;
  private RecipePostDTO recipe;

}
