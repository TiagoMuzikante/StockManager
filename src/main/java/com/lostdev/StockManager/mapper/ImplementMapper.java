package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.DTOs.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.stock.Implement;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.service.RecipeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ImplementMapper {

  @Autowired
  protected RecipeService recipeService;

  @Mapping(source = "recipeId", target = "recipe", qualifiedByName = "idToRecipe")
  public abstract Implement toImplement(ImplementPostDTO implementPostDTO);

  @Named("idToRecipe")
  protected Recipe idToRecipe(Long id){
    return recipeService.findById(id);
  }

}
