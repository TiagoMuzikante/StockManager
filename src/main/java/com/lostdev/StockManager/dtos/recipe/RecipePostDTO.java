package com.lostdev.StockManager.dtos.recipe;

import com.lostdev.StockManager.dtos.utils.ProductItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipePostDTO {

  private List<ProductItemDTO> productItems;

}
