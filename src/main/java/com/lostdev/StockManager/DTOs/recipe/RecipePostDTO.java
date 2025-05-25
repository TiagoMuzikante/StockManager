package com.lostdev.StockManager.DTOs.recipe;

import com.lostdev.StockManager.DTOs.utils.ProductItemDTO;
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

  private Long id;

  private List<ProductItemDTO> productItemDTOs;

}
