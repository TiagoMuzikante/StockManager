package com.lostdev.StockManager.dtos.Implement;


import com.lostdev.StockManager.dtos.recipe.RecipeBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImplementBasicDTO {

  private String name;
  private RecipeBasicDTO recipe;

}
