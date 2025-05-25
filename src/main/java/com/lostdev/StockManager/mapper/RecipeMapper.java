package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import com.lostdev.StockManager.DTOs.utils.ProductItemDTO;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.domain.utils.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class RecipeMapper {

  protected ProductItemMapper productItemMapper;

  @Mapping(source = "productItemDTOs", target = "productItems", qualifiedByName = "toProductItemList")
  public abstract Recipe toRecipe(RecipePostDTO recipePostDTO);

  @Named("toProductItemList")
  protected List<ProductItem> toProductItemList(List<ProductItemDTO> productItemDTOS){
    return productItemDTOS
        .stream()
        .map(productItemMapper::toProductItem)
        .collect(Collectors.toList());
  }

}
