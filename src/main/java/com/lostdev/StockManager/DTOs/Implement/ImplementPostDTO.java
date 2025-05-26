package com.lostdev.StockManager.DTOs.Implement;

import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImplementPostDTO {

  private String name;
  private Long recipeId;

  private RecipePostDTO recipePostDTO;
}
