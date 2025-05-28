package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.DTOs.recipe.RecipeBasicDTO;
import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import com.lostdev.StockManager.DTOs.utils.ProductItemDTO;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.domain.utils.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ProductItemMapper.class)
public abstract class RecipeMapper {

  @Autowired
  protected ProductItemMapper productItemMapper;

  public abstract RecipeBasicDTO toBasic(Recipe recipe);

  @Mapping(source = "productItems", target = "productItems", qualifiedByName = "toProductItemList")
  public abstract Recipe toRecipe(RecipePostDTO recipePostDTO);

  @Named("toProductItemList")
  protected List<ProductItem> toProductItemList(List<ProductItemDTO> productItems){
    return productItems
        .stream()
        .map(productItemMapper::toProductItem)
        .collect(Collectors.toList());
  }
}
