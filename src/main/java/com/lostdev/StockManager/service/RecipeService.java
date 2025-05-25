package com.lostdev.StockManager.service;

import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.mapper.RecipeMapper;
import com.lostdev.StockManager.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipeService {

  private final RecipeRepository recipeRepository;
  private final RecipeMapper recipeMapper;

  public Recipe save(RecipePostDTO recipePostDTO){
    return recipeRepository.save(recipeMapper.toRecipe(recipePostDTO));
  }

  public List<Recipe> listAll(){
    return recipeRepository.findAll();
  }

  public Recipe findById(Long id){
    return recipeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nenhum resultado encontrado"));
  }

}
