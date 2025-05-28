package com.lostdev.StockManager.dtos.recipe;

import com.lostdev.StockManager.dtos.utils.ProductItemBasicDTO;
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
