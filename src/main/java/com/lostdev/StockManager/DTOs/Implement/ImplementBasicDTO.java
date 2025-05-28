package com.lostdev.StockManager.DTOs.Implement;


import com.lostdev.StockManager.DTOs.recipe.RecipeBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImplementBasicDTO {

  private String name;
  private RecipeBasicDTO recipe;

}
