package com.lostdev.StockManager.DTOs.Implement;

import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImplementPostDTO {

  private String name;
  private RecipePostDTO recipe;

}
