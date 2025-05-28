package com.lostdev.StockManager.DTOs.recipe;

import com.lostdev.StockManager.DTOs.utils.ProductItemBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeBasicDTO {

  private Long id;
  private List<ProductItemBasicDTO> productItems;

}
